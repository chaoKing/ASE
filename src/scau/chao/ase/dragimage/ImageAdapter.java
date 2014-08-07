/**
 * Copyright (c) 华楠农业大学蔡超敏 2014 版权所有
 * 
 * 文件创建时间：2014-8-7
 */
package scau.chao.ase.dragimage;

import scau.chao.ase.R;
import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * @author 蔡超敏
 * 
 */
public class ImageAdapter extends BaseAdapter {

  private Activity activity;// 建构子只有一个参数， 即要储存的Context
  private int[] myImageIds = {R.drawable.guide_1_1, R.drawable.guide_2_1, R.drawable.guide_3_1,
      R.drawable.guide_4_1}; // 使用android.R.drawable里的图片作为图库来源，类型为整数数组

  /**
   * @param Activity
   */
  public ImageAdapter(Activity activity) {
    this.activity = activity;
  }

  /*
   * 利用getItem方法，取得目前容器中影像的数组ID
   */
  @Override
  public int getCount() {
    Log.d("ImageAdapter-getCount", "getCount");
    return Integer.MAX_VALUE;
  }

  /*
   * 取得目前欲显示的影像View，传入数组ID值使之读取与成像
   */
  @Override
  public Object getItem(int position) {
    Log.d("ImageAdapter-getItem", "position = " + position);
    return position;
  }

  /*
   * 取得目前欲显示的影像View，传入数组ID值使之读取与成像
   */
  @Override
  public long getItemId(int position) {
    Log.d("ImageAdapter-getItemId", "position = " + position);
    return position;
  }

  /*
   * 设定这个ImageView对象的宽高，单位为dip
   */
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    DisplayMetrics mDisplayMetrics = new DisplayMetrics();
    activity.getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
    int width = mDisplayMetrics.widthPixels;
    int height = mDisplayMetrics.heightPixels;

    if (position < 0) {
      position = -position;
    }

    ImageView i = new ImageView(activity);
    i.setImageResource(this.myImageIds[position % myImageIds.length]);
    i.setScaleType(ImageView.ScaleType.FIT_XY);
    i.setLayoutParams(new Gallery.LayoutParams(width, height));
    return i;
  }

  /**
   * Formula: 1 / (2 ^ offset)
   * 
   * @param focused
   * @param offset
   * @return float
   */
  public float getScale(boolean focused, int offset) {
    return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
  }

}
