package xal.cn.com.kaishu_story.weight;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.OnClick;
import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.base.BaseActivity;

/**
 * Created by Administrator on 2017/11/8.
 * 作者:刘鑫
 */

public class StartActivity extends BaseActivity {
    @BindView(R.id.bofang_img_fanhui)
    ImageView bofangImgFanhui;
    @BindView(R.id.bofang_img_fenxiang)
    ImageView bofangImgFenxiang;
    @BindView(R.id.toobar)
    Toolbar toobar;
    @BindView(R.id.img_beijing)
    ImageView imgBeijing;
    @BindView(R.id.seekbar)
    SeekBar seekbar;
    @BindView(R.id.tv_dangqianshijian)
    TextView tvDangqianshijian;
    @BindView(R.id.tv_zongshijian)
    TextView tvZongshijian;
    @BindView(R.id.r1)
    LinearLayout r1;
    @BindView(R.id.tv_gequname)
    TextView tvGequname;
    @BindView(R.id.img_shangyishou)
    ImageView imgShangyishou;
    @BindView(R.id.img_bofang)
    ImageView imgBofang;
    @BindView(R.id.img_xiayishou)
    ImageView imgXiayishou;
    @BindView(R.id.r2)
    RelativeLayout r2;
    @BindView(R.id.img_shoucang)
    ImageView imgShoucang;
    @BindView(R.id.img_xiazai)
    ImageView imgXiazai;
    @BindView(R.id.img_dingshi)
    ImageView imgDingshi;
    @BindView(R.id.img_liebiao)
    ImageView imgLiebiao;
    @BindView(R.id.activity_bo_fang_qi_)
    RelativeLayout activityBoFangQi;

    private Handler mHandler = new Handler();
    private MyService.MyBinder mMyBinder;

    private Intent MediaServiceIntent;

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            seekBar.setProgress(mMyBinder.getPlayPosition());
            //  recycAdapterActivity_title.setText(time.format(mMyBinder.getPlayPosition()) + "s");
            mHandler.postDelayed(mRunnable, 1000);
        }
    };
    private SimpleDateFormat time = new SimpleDateFormat("m:ss");
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMyBinder = (MyService.MyBinder) service;
//            mMediaService = ((MediaService.MyBinder) service).getInstance();
            seekBar.setMax(mMyBinder.getProgress());

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    //这里很重要，如果不判断是否来自用户操作进度条，会不断执行下面语句块里面的逻辑，然后就会卡顿卡顿
                    if (fromUser) {
                        mMyBinder.seekToPositon(seekBar.getProgress());
//                    mMediaService.mMediaPlayer.seekTo(seekBar.getProgress());
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            mHandler.post(mRunnable);

            Log.d("TAG", "Service与Activity已连接");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private SeekBar seekBar;
    private String mps;
    private MediaPlayer mediaPlayer;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {
        seekBar = findViewById(R.id.seekbar);
    }

    @Override
    protected void initData() {
       /* MediaServiceIntent = new Intent(this, MediaService.class);
        MediaServiceIntent.putExtra("mpsa", mps);
        startService(MediaServiceIntent);
        //判断权限够不够，不够就给
        if (ContextCompat.checkSelfPermission(StartActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(StartActivity.this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 1);
        } else {
            //够了就设置路径等，准备播放
            bindService(MediaServiceIntent, mServiceConnection, BIND_AUTO_CREATE);
        }*/

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        /*switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    bindService(MediaServiceIntent, mServiceConnection, BIND_AUTO_CREATE);
                } else {
                    Toast.makeText(this, "权限不够获取不到音乐，程序将退出", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }*/
    }

    @Override
    protected void initDate() {
        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        String name = intent.getStringExtra("name");
        String time = intent.getStringExtra("time");
        Log.e("TAG", "AAA"+time);
        mps = intent.getStringExtra("mp3");
        tvZongshijian.setText(time);
        tvGequname.setText(name);
        Glide.with(StartActivity.this).load(image).into(imgBeijing);
        initWKZ(mps);

    }
    protected void initWKZ(String mp3){
        mediaPlayer = MediaPlayer.create(this, Uri.parse(mp3));

    }

    @OnClick({R.id.bofang_img_fanhui, R.id.bofang_img_fenxiang, R.id.img_shangyishou, R.id.img_bofang, R.id.img_xiayishou, R.id.img_shoucang, R.id.img_xiazai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bofang_img_fanhui:
                finish();
                break;
            case R.id.bofang_img_fenxiang:
                break;
            case R.id.img_shangyishou:
                break;
            case R.id.img_bofang:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }else{
                    mediaPlayer.start();
                }
                //mMyBinder.pauseMusic(view);
                break;
            case R.id.img_xiayishou:
                break;
            case R.id.img_shoucang:
                break;
            case R.id.img_xiazai:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //我们的handler发送是定时1000s发送的，如果不关闭，MediaPlayer release掉了还在获取getCurrentPosition就会爆IllegalStateException错误
        mHandler.removeCallbacks(mRunnable);

        //  mMyBinder.closeMedia();
        //  unbindService(mServiceConnection);
        StartActivity.this.stopService(new
                Intent(StartActivity.this,
                MyService.class));

    }
}
