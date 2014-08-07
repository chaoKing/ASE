/**
 * Copyright (c) 华楠农业大学蔡超敏 2014 版权所有
 * 
 * 文件创建时间：2014-8-7
 */
package scau.chao.ase.dragimage;

import scau.chao.ase.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Gallery;

/**
 * 拖拉图片
 * 
 * @author 蔡超敏
 * 
 */
public class DragImageActivity extends Activity {
  // TextView mTextView01;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_drag_image);
    // mTextView01 = (TextView) findViewById(R.id.myTextView01);
    // mTextView01.setText(getString(R.string.app_name));
    // mTextView01.setTextColor(Color.BLUE);
    Gallery gallery = ((Gallery) findViewById(R.id.myGallery1));
    gallery.setAdapter(new ImageAdapter(this));
    gallery.setSelection(Integer.MAX_VALUE / 2);
  }
  
  

}
