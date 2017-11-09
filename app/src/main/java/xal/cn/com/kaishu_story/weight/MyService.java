package xal.cn.com.kaishu_story.weight;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;

import xal.cn.com.kaishu_story.R;

public class MyService extends Service {

    private static final String TAG = "MediaService";
    private MyBinder mBinder = new MyBinder();
    private String mps;

    @Override
    public void onStart(Intent intent, int startId) {
        mps = intent.getStringExtra("mp3");
        ArrayList<String> list = new ArrayList<>();
        list.add(mps);
        iniMediaPlayerFile(list);
    }


    public MediaPlayer mMediaPlayer = new MediaPlayer();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class MyBinder extends Binder {
        public void pauseMusic(View view) {
            if (mMediaPlayer.isPlaying()) {
                //如果还没开始播放，就开始
                mMediaPlayer.pause();
                //playoff_shadow.png
                ((ImageView)view).setImageResource(R.drawable.exo_controls_play);
            }else {
                mMediaPlayer.start();
                ((ImageView)view).setImageResource(R.drawable.exo_controls_pause);
            }
        }
        public void closeMedia() {
            if (mMediaPlayer != null) {
                mMediaPlayer.stop();
                mMediaPlayer.release();
            }
        }
        /**
         * 获取歌曲长度
         **/
        public int getProgress() {

            return mMediaPlayer.getDuration();
        }
        /**
         * 获取播放位置
         */
        public int getPlayPosition() {

            return mMediaPlayer.getCurrentPosition();
        }
        /**
         * 播放指定位置
         */
        public void seekToPositon(int msec) {
            mMediaPlayer.seekTo(msec);
        }
    }
    /**
     * 添加file文件到MediaPlayer对象并且准备播放音频
     *
     */

    private void iniMediaPlayerFile(ArrayList list) {
        //获取文件路径
        try {
            //此处的两个方法需要捕获IO异常
            //设置音频文件到MediaPlayer对象中
            mMediaPlayer.setDataSource(list.get(0).toString());
            //让MediaPlayer对象准备
            mMediaPlayer.prepare();
            list.clear();
        } catch (IOException e) {
            Log.d(TAG, "设置资源，准备阶段出错");
            e.printStackTrace();
        }
    }

}
