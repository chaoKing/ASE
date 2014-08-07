/**
 * Copyright (c) 广州顶九信息技术有限公司 2014 版权所有
 * 
 * 文件创建时间：2014-8-7
 */
package scau.chao.ase.splash;

import scau.chao.ase.MainActivity;
import scau.chao.ase.R;
import scau.chao.ase.guide.GuideActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.VideoView;

/**
 * 启动画面
 * 
 * @author 蔡超敏
 * 
 */
public class SplashActivity extends Activity {

  boolean isFirstIn = false;

  private static final int GO_HOME = 1000;
  private static final int GO_GUIDE = 1001;
  // 延迟3秒
  private static final long SPLASH_DELAY_MILLIS = 100;

  private static final String SHAREDPREFERENCES_NAME = "first_start_info";

  // 新加的播放控件
  private VideoView videoView;

  /**
   * Handler:跳转到不同界面
   */
  private Handler mHandler = new Handler() {

    @Override
    public void handleMessage(Message msg) {
      switch (msg.what) {
        case GO_HOME:
          goHome();
          break;
        case GO_GUIDE:
          goGuide();
          break;
      }
      super.handleMessage(msg);
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_3gp);

    toShowVideo();

    // init();
  }

  /**
   * 播放动画
   */
  private void toShowVideo() {
    /* 设定VideoView */
    videoView = (VideoView) findViewById(R.id.mVideoView1);
    // 资源传入路径格式： android.resource://[package name]/R.raw.start
    Uri uri = Uri.parse("android.resource://scau.chao.ase/" + R.raw.start);
    videoView.setVideoURI(uri);
    videoView.requestFocus();
    /* 开始播放影片 */
    videoView.start();

    /* 影片播放完后会运行的OnCompletionListener */
    videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
      @Override
      public void onCompletion(MediaPlayer arg0) {
        init();
      }
    });
  }

  private void init() {
    // 读取SharedPreferences中需要的数据
    // 使用SharedPreferences来记录程序的使用次数
    SharedPreferences preferences = getSharedPreferences(SHAREDPREFERENCES_NAME, MODE_PRIVATE);

    // 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
    isFirstIn = preferences.getBoolean("isFirstStart1", true);

    // 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
    if (!isFirstIn) {
      // 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
      mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
    } else {
      mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
    }

  }

  private void goHome() {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
    finish();
  }

  private void goGuide() {
    Intent intent = new Intent(this, GuideActivity.class);
    startActivity(intent);
    finish();
  }

}
