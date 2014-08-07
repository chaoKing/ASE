/**
 * Copyright (c) 广州顶九信息技术有限公司 2014 版权所有
 * 
 * 文件创建时间：2014-8-5
 */
package scau.chao.ase.guide;

import java.util.ArrayList;
import java.util.List;

import scau.chao.ase.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 安装软件第一次启动介绍界面activity
 * 
 * @author 蔡超敏
 * 
 */
public class GuideActivity extends Activity implements OnPageChangeListener {

  private ViewPager viewPager;
  private GuideViewPagerAdapter vpAdapter;
  private List<View> views;

  // 底部小点图片
  private ImageView[] dots;

  // 记录当前选中位置
  private int currentIndex;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_guide);

    initViews();

    initDots();
  }


  /**
   * 初始化底部小点
   */
  private void initDots() {
    LinearLayout ll = (LinearLayout) findViewById(R.id.ll);

    dots = new ImageView[views.size()];

    // 循环取得小点图片
    for (int i = 0; i < views.size(); i++) {
      dots[i] = (ImageView) ll.getChildAt(i);
      dots[i].setEnabled(true);// 都设为灰色
    }

    currentIndex = 0;
    dots[currentIndex].setEnabled(false);// 设置为白色，即选中状态
  }


  /**
   * 初始化页面
   */
  private void initViews() {
    LayoutInflater inflater = LayoutInflater.from(this);

    views = new ArrayList<View>();
    // 初始化引导图片列表
    views.add(inflater.inflate(R.layout.pager_one, null));
    views.add(inflater.inflate(R.layout.pager_two, null));
    views.add(inflater.inflate(R.layout.pager_three, null));
    views.add(inflater.inflate(R.layout.pager_four, null));

    // 初始化Adapter
    vpAdapter = new GuideViewPagerAdapter(views, this);

    viewPager = (ViewPager) findViewById(R.id.viewpager);
    viewPager.setAdapter(vpAdapter);
    // 绑定回调
    viewPager.setOnPageChangeListener(this);
  }

  private void setCurrentDot(int position) {
    if (position < 0 || position > views.size() - 1 || currentIndex == position) {
      return;
    }

    dots[position].setEnabled(false);
    dots[currentIndex].setEnabled(true);

    currentIndex = position;
  }


  @Override
  public void onPageScrollStateChanged(int arg0) {}


  @Override
  public void onPageScrolled(int arg0, float arg1, int arg2) {}


  @Override
  public void onPageSelected(int arg0) {
    // 设置底部小点选中状态
    setCurrentDot(arg0);
  }


}
