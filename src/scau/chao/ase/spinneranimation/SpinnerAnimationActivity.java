/**
 * Copyright (c) 华楠农业大学蔡超敏 2014 版权所有
 * 
 * 文件创建时间：2014-8-9
 */
package scau.chao.ase.spinneranimation;

import scau.chao.ase.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author 蔡超敏
 * 
 */
public class SpinnerAnimationActivity extends Activity {

  private static final String[] countriesStr = {"台北市", "台北县", "台中市", "高雄市"};
  private TextView myTextView;
  private Spinner mySpinner;
  private ArrayAdapter adapter;
  Animation myAnimation;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    /* 载入main.xml Layout */
    setContentView(R.layout.activity_spinner_animation);
    /* 以findViewById()取得对象 */
    myTextView = (TextView) findViewById(R.id.myTextView);
    mySpinner = (Spinner) findViewById(R.id.mySpinner);
    adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countriesStr);
    /* myspinner_dropdown为自定义下拉菜单样式定义在res/layout目录下 */
    adapter.setDropDownViewResource(R.layout.item_myspinner_animation);
    /* 将ArrayAdapter加入Spinner对象中 */mySpinner.setAdapter(adapter);
    /* 将mySpinner加入OnItemSelectedListener */
    mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView arg0, View arg1, int arg2, long arg3) {
        /* 将所选mySpinner的值带入myTextView中 */
        myTextView.setText("选择的是" + countriesStr[arg2]);
        /* 将mySpinner显示 */
        arg0.setVisibility(View.VISIBLE);
      }

      @Override
      public void onNothingSelected(AdapterView arg0) {
        // TODO Auto-generated method stub
      }
    });
    /* 取得Animation定义在res/anim目录下 */
    myAnimation = AnimationUtils.loadAnimation(this, R.anim.my_anim);
    /* 将mySpinner加入OnTouchListener */
    mySpinner.setOnTouchListener(new Spinner.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        /* 将mySpinner执行Animation */
        v.startAnimation(myAnimation);
        /* 将mySpinner隐藏 */
        v.setVisibility(View.INVISIBLE);
        return false;
      }
    });
    mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        // TODO Auto-generated method stub
      }
    });
  }

}
