/**
 * Copyright (c) 广州顶九信息技术有限公司 2014 版权所有
 * 
 * 文件创建时间：2014-8-5
 */

package scau.chao.ase.guide;

import java.util.List;

import scau.chao.ase.MainActivity;
import scau.chao.ase.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * 
 * GuideActivity的ViewPager的适配器
 * 
 * @author 蔡超敏
 * 
 */
public class GuideViewPagerAdapter extends PagerAdapter {
  // 界面列表
  private List<View> views;
  private Activity activity;

  public GuideViewPagerAdapter(List<View> views, Activity activity) {
    this.views = views;
    this.activity = activity;
  }

  // 销毁arg1位置的界面
  @Override
  public void destroyItem(View arg0, int arg1, Object arg2) {
    ((ViewPager) arg0).removeView(views.get(arg1));
  }

  @Override
  public void finishUpdate(View arg0) {}

  // 获得当前界面数
  @Override
  public int getCount() {
    if (views != null) {
      return views.size();
    }
    return 0;
  }

  // 初始化arg1位置的界面
  @Override
  public Object instantiateItem(View arg0, int arg1) {
    ((ViewPager) arg0).addView(views.get(arg1), 0);
    if (arg1 == views.size() - 1) {
      ImageView mStartDing9ImageButton = (ImageView) arg0.findViewById(R.id.iv_start_ding9);
      mStartDing9ImageButton.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
          toSkipMainActivity();
        }

      });
    }
    return views.get(arg1);
  }

  /**
   * 跳转到主界面
   */
  private void toSkipMainActivity() {
    Log.d("LoadActivity", "跳转到主界面");
    Intent mainIntent = new Intent(activity, MainActivity.class);
    activity.startActivity(mainIntent);
    activity.finish();
  }

  // 判断是否由对象生成界面
  @Override
  public boolean isViewFromObject(View arg0, Object arg1) {
    return (arg0 == arg1);
  }

  @Override
  public void restoreState(Parcelable arg0, ClassLoader arg1) {}

  @Override
  public Parcelable saveState() {
    return null;
  }

  @Override
  public void startUpdate(View arg0) {}

}
