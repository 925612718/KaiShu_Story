package xal.cn.com.kaishu_story.weight;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;
import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.base.BaseActivity;
import xal.cn.com.kaishu_story.view.HomePagerActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.dao)
    Button dao;
    @BindView(R.id.main_image)
    ImageView mainImage;
    private int x = 3;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            x--;
            dao.setText(x+"");
            handler.postDelayed(runnable,1000);
            if(x==0) {

                startActivity(new Intent(MainActivity.this,HomePagerActivity.class));
                finish();
            }
        }
    };

//    private Thread thread1;
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what) {
//                case 200:
//                    mainImage.setImageResource(R.drawable.d);
//                    thread1.start();
//                    dao.setVisibility(View.VISIBLE);
//                    break;
//                case 300:
//                    dao.setText("跳过" + x);
//                    break;
//            }
//        }
//    };
    private Timer timer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        handler.postDelayed(runnable,1000);
    }

    @Override
    protected void initData() {
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                handler.sendEmptyMessage(200);
//            }
//        };
//        thread.start();
//        thread1 = new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                timer = new Timer();
//                timer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        if (x == 0) {
//                            x--;
//                            startActivity(new Intent(MainActivity.this, HomePagerActivity.class));
//                            timer.cancel();
//                        }
//                    }
//                }, 1000, 1000);
//            }
//        };
    }

    @Override
    protected void initDate() {

    }


    @OnClick(R.id.dao)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dao:
                Intent intent = new Intent(this, HomePagerActivity.class);
                startActivity(intent);
                handler.removeCallbacks(runnable);
                finish();
//                timer.cancel();
                break;

        }
    }
}

