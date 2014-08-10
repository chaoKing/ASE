/**
 * Copyright (c) 华楠农业大学蔡超敏 2014 版权所有
 * 
 * 文件创建时间：2014-8-10
 */
package scau.chao.ase.slidingdrawer;

import scau.chao.ase.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author 蔡超敏
 * 
 */
public class MyGridViewAdapter extends BaseAdapter {

  private Context mContext;
  private String[] _items;
  private int[] _icons;

  /* 构造符 */
  public MyGridViewAdapter(Context mContext, String[] items, int[] icons) {
    this.mContext = mContext;
    _items = items;
    _icons = icons;
  }

  @Override
  public int getCount() {
    return _items.length;
  }

  @Override
  public Object getItem(int arg0) {
    return _items[arg0];
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater factory = LayoutInflater.from(mContext);
    /* 使用grid.xml为每几个item的Layout */
    View v = (View) factory.inflate(R.layout.item_my_grid_view, null);
    /* 取得View */
    ImageView iv = (ImageView) v.findViewById(R.id.icon);
    TextView tv = (TextView) v.findViewById(R.id.text);
    /* 设定显示的Image与文? */
    iv.setImageResource(_icons[position]);
    tv.setText(_items[position]);
    return v;
  }

}
