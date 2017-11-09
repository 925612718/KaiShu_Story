package xal.cn.com.kaishu_story.weight;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mob.MobSDK;

import org.json.JSONObject;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import xal.cn.com.kaishu_story.R;

public class MobActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "SmsYanzheng";
    EditText mEditTextPhoneNumber;
    EditText mEditTextCode;
    Button mButtonGetCode;
    Button mButtonLogin;
    EventHandler eventHandler;
    String strPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mob);
        mEditTextPhoneNumber = (EditText) findViewById(R.id.edname);
        mEditTextCode = (EditText) findViewById(R.id.edagr);
        mButtonGetCode = (Button) findViewById(R.id.main_hq);
        mButtonLogin = (Button) findViewById(R.id.main_dl);

        mButtonGetCode.setOnClickListener(this);
        mButtonLogin.setOnClickListener(this);

        //需要验证自己申请的  AppKey
        MobSDK.init(this, "2203e61452d99", "2d835f1042d42c1858887923a5359bea");


        //设置监听
        eventHandler = new EventHandler() {

            @Override
            public void afterEvent(int event, int result, Object data) {
                Message message = myHandler.obtainMessage(0x00);
                message.arg1 = event;
                message.arg2 = result;
                message.obj = data;
                myHandler.sendMessage(message);
            }
        };

        SMSSDK.registerEventHandler(eventHandler);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁
        SMSSDK.unregisterEventHandler(eventHandler);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.main_dl) {
            String strCode = mEditTextCode.getText().toString();
            if (null != strCode && strCode.length() == 4) {
                Log.d(TAG, mEditTextCode.getText().toString());
                SMSSDK.submitVerificationCode("86", strPhoneNumber, mEditTextCode.getText().toString());
            } else {
                Toast.makeText(this, "密码长度不正确", Toast.LENGTH_SHORT).show();
                Log.e(TAG,"密码长度不正确");
            }
        } else if (view.getId() == R.id.main_hq) {
            strPhoneNumber = mEditTextPhoneNumber.getText().toString();
            if (null == strPhoneNumber || "".equals(strPhoneNumber) || strPhoneNumber.length() != 11) {
                Toast.makeText(this, "电话号码输入有误", Toast.LENGTH_SHORT).show();
                Log.e(TAG,"电话号码输入有误");
                return;
            }
            //验证通过 将发送短信到这个号码上面
            SMSSDK.getVerificationCode("86", strPhoneNumber);
            Log.e(TAG,SMSSDK.getVersion());
            mButtonGetCode.setClickable(false);
            //开启线程去更新button的text
            new Thread() {
                @Override
                public void run() {
                    int totalTime = 60;
                    for (int i = 0; i < totalTime; i++) {
                        Message message = myHandler.obtainMessage(0x01);
                        message.arg1 = totalTime - i;
                        myHandler.sendMessage(message);
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    myHandler.sendEmptyMessage(0x02);
                }
            }.start();
        }
    }

    Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x00:
                    int event = msg.arg1;
                    int result = msg.arg2;
                    Object data = msg.obj;
                    Log.e(TAG, "result : " + result + ", event: " + event + ", data : " + data);
                    if (result == SMSSDK.RESULT_COMPLETE) { //回调  当返回的结果是complete
                        if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) { //获取验证码
                            Toast.makeText(MobActivity.this, "发送验证码成功", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "发送验证码成功");
                        } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) { //提交验证码
                            Log.d(TAG, "提交验证码成功");
                            Toast.makeText(MobActivity.this, "提交验证码成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.d(TAG, data.toString());
                        }
                    } else { //进行操作出错，通过下面的信息区分析错误原因
                        try {
                            Throwable throwable = (Throwable) data;
                            throwable.printStackTrace();
                            JSONObject object = new JSONObject(throwable.getMessage());
                            String des = object.optString("detail");//错误描述
                            int status = object.optInt("status");//错误代码
                            //错误代码：  http://wiki.mob.com/android-api-%E9%94%99%E8%AF%AF%E7%A0%81%E5%8F%82%E8%80%83/
                            Log.e(TAG, "status: " + status + ", detail: " + des);
                            if (status > 0 && !TextUtils.isEmpty(des)) {
                                Toast.makeText(MobActivity.this, des, Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 0x01:
                    mButtonGetCode.setText("重新发送(" + msg.arg1 + ")");
                    break;
                case 0x02:
                    mButtonGetCode.setText("获取验证码");
                    mButtonGetCode.setClickable(true);
                    break;
            }
        }
    };
}
