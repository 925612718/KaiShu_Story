package xal.cn.com.kaishu_story.weight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xal.cn.com.kaishu_story.R;

public class LoginActivityy extends AppCompatActivity {

    @BindView(R.id.bt_weixin)
    Button btWeixin;
    @BindView(R.id.bt_phoneNumber)
    Button btPhoneNumber;
    @BindView(R.id.mBut_xy)
    Button mButXy;
    @BindView(R.id.login_back)
    ImageView loginBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activityy);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_weixin, R.id.bt_phoneNumber,R.id.login_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_weixin:
                UMShareAPI.get(this).getPlatformInfo(LoginActivityy.this, SHARE_MEDIA.QQ, umAuthListener);


                break;
            case R.id.bt_phoneNumber:
                startActivity(new Intent(this, MobActivity.class));
                break;
            case R.id.login_back:
               finish();
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
            String s1 = data.get("screen_name");
            String s = data.get("profile_image_url");
            String openid = data.get("openid");
            Intent intent = new Intent("MyFragment");
            intent.putExtra("img",s);
            intent.putExtra("name",s1);
            intent.putExtra("ID",openid);
            sendBroadcast(intent);
            finish();

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
}
