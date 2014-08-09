/**
 * Copyright (c) 华楠农业大学蔡超敏 2014 版权所有
 * 
 * 文件创建时间：2014-8-9
 */
package scau.chao.ase.rotateimage;

import scau.chao.ase.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * 注意：Matrix操作有先后区别
 * 
 * @author 蔡超敏
 * 
 */
public class RotateImageActivity extends Activity {
  private Button mButton1;
  private Button mButton2;
  private Button mButton3;
  private Button mButton4;
  private TextView mTextView1;
  private ImageView mImageView1;
  private float ScaleTimes;
  private int ScaleAngle;
  private int widthOrig;
  private int heightOrig;
  private Bitmap mySourceBmp;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rotate_image);
    mButton1 = (Button) findViewById(R.id.myButton1);
    mButton2 = (Button) findViewById(R.id.myButton2);
    mButton3 = (Button) findViewById(R.id.myButton3);
    mButton4 = (Button) findViewById(R.id.myButton4);
    mTextView1 = (TextView) findViewById(R.id.myTextView1);
    mImageView1 = (ImageView) findViewById(R.id.myImageView1);
    ScaleTimes = 1;
    ScaleAngle = 1;
    mySourceBmp = BitmapFactory.decodeResource(getResources(), R.drawable.hippo);
    widthOrig = mySourceBmp.getWidth();
    heightOrig = mySourceBmp.getHeight();
    /* 程序刚执行，加载默认的Drawable */
    mImageView1.setImageBitmap(mySourceBmp);

    /* 向左选转按钮 */
    mButton1.setOnClickListener(new Button.OnClickListener() {

      @Override
      public void onClick(View v) {
        ScaleAngle--;

        Matrix matrix = new Matrix();

        matrix.setRotate(5 * ScaleAngle);
        matrix.postScale(ScaleTimes, ScaleTimes);

        /* 建立新的Bitmap对象 */
        Bitmap resizedBitmap =
            Bitmap.createBitmap(mySourceBmp, 0, 0, widthOrig, heightOrig, matrix, true);
        /**/
        // BitmapDrawable myNewBitmapDrawable = new BitmapDrawable(resizedBitmap);
        // mImageView1.setImageDrawable(myNewBitmapDrawable);
        mImageView1.setImageBitmap(resizedBitmap);
        mTextView1.setText(Integer.toString(5 * ScaleAngle));


      }
    });
    /* 向右选转按钮 */
    mButton2.setOnClickListener(new Button.OnClickListener() {
      @Override
      public void onClick(View v) {
        ScaleAngle++;

        Matrix matrix = new Matrix();

        matrix.setRotate(5 * ScaleAngle);
        matrix.postScale(ScaleTimes, ScaleTimes);

        /* 建立新的Bitmap对象 */
        Bitmap resizedBitmap =
            Bitmap.createBitmap(mySourceBmp, 0, 0, widthOrig, heightOrig, matrix, true);
        // BitmapDrawable myNewBitmapDrawable = new BitmapDrawable(resizedBitmap);
        // mImageView1.setImageDrawable(myNewBitmapDrawable);
        mImageView1.setImageBitmap(resizedBitmap);
        mTextView1.setText(Integer.toString(5 * ScaleAngle));
        Log.d("RotateImageActivity-onClick", "ScaleTimes = " + ScaleTimes);
      }
    });


    mButton3.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        mImageView1.setPadding(mImageView1.getPaddingLeft(), mImageView1.getPaddingTop() + 15,
            mImageView1.getPaddingRight(), mImageView1.getPaddingBottom());
      }
    });
    mButton4.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        // LayoutParams layoutParams = mImageView1.getLayoutParams();
        // Log.d("RotateImageActivity-onClick", "layoutParams.height = " + layoutParams.height);
        // Log.d("RotateImageActivity-onClick", "layoutParams.width = " + layoutParams.width);
        Log.d("RotateImageActivity-onClick", "mySourceBmp.getWidth() = " + mySourceBmp.getWidth());
        Log.d("RotateImageActivity-onClick", "mySourceBmp.getHeight() = " + mySourceBmp.getHeight());
        // ScaleTimes += 0.1;
        // layoutParams.height = (widthOrig *= ScaleTimes);
        // layoutParams.width = heightOrig *= ScaleTimes;
        // mImageView1.setLayoutParams(layoutParams);

        Matrix matrix = new Matrix();

        ScaleTimes += 0.2;
        if (ScaleAngle == 1) {
          matrix.setRotate(ScaleAngle);
        } else {
          matrix.setRotate(5 * ScaleAngle);
        }
        matrix.postScale(ScaleTimes, ScaleTimes);

        Bitmap resizedBitmap =
            Bitmap.createBitmap(mySourceBmp, 0, 0, widthOrig, heightOrig, matrix, true);
        mImageView1.setImageBitmap(resizedBitmap);
        Log.d("RotateImageActivity-onClick", "ScaleTimes = " + ScaleTimes);

      }
    });
  }
}
