/**
 * Copyright (c) 华楠农业大学蔡超敏 2014 版权所有
 * 
 * 文件创建时间：2014-8-9
 */
package scau.chao.ase.playguessplacard;

import scau.chao.ase.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author 蔡超敏
 * 
 */
public class PlayGuessPlacardActivity extends Activity {
  private ImageView mImageView01;
  private ImageView mImageView02;
  private ImageView mImageView03;
  private Button mButton;
  private TextView mText;
  /*
   * 宣告长度为3的int数组，并将三张牌的id放入 R.drawable.p01：红心A R.drawable.p02：黑桃2 R.drawable.p03：梅花3
   * R.drawable.p04：扑克牌背面
   */
  private static int[] s1 = new int[] {R.drawable.p01, R.drawable.p02, R.drawable.p03};

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState); // 载入main.xml Layout
    setContentView(R.layout.activity_play_guess_placard); // 取得相关对象
    mText = (TextView) findViewById(R.id.mText);
    mImageView01 = (ImageView) findViewById(R.id.mImage01);
    mImageView02 = (ImageView) findViewById(R.id.mImage02);
    mImageView03 = (ImageView) findViewById(R.id.mImage03);
    mButton = (Button) findViewById(R.id.mButton); // 执行洗牌程序
    random();
    /* 替mImageView01加入onClickListener */
    mImageView01.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        setOpenPlacard(1);
      }
    }); /* 替mImageView02加入onClickListener */
    mImageView02.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        setOpenPlacard(2);
      }
    }); /* 替mImageView03加入onClickListener */
    mImageView03.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        setOpenPlacard(3);
      }
    }); /* 替mButton加入onClickListener，使其按下后三张牌都翻为背面且重新洗牌 */
    mButton.setOnClickListener(new Button.OnClickListener() {
      public void onClick(View v) {
        mText.setText("猜猜看红心A是哪一张?");
        mImageView01.setImageDrawable(getResources().getDrawable(R.drawable.p04));
        mImageView02.setImageDrawable(getResources().getDrawable(R.drawable.p04));
        mImageView03.setImageDrawable(getResources().getDrawable(R.drawable.p04));
        mImageView01.setAlpha(255);
        mImageView02.setAlpha(255);
        mImageView03.setAlpha(255);
        mImageView01.setEnabled(true);
        mImageView02.setEnabled(true);
        mImageView03.setEnabled(true);
        random();
      }
    });
  }

  /**
   * 三张牌同时翻面，并将未选择的两张牌变透明
   * 
   * @param num
   */
  private void setOpenPlacard(int num) {
    num--;
    mImageView01.setImageDrawable(getResources().getDrawable(s1[0]));
    mImageView02.setImageDrawable(getResources().getDrawable(s1[1]));
    mImageView03.setImageDrawable(getResources().getDrawable(s1[2]));
    switch (num) {
      case 0:
        mImageView02.setAlpha(100);
        mImageView03.setAlpha(100);
        break;
      case 1:
        mImageView01.setAlpha(100);
        mImageView03.setAlpha(100);
        break;
      case 2:
        mImageView01.setAlpha(100);
        mImageView02.setAlpha(100);
        break;
      default:
        break;
    }
    if (s1[num] == R.drawable.p01) {
      mText.setText("哇!你猜对了喔!!拍拍手!");
    } else {
      mText.setText("你猜错了喔!!要不要再试一次?");
    }
    mImageView01.setEnabled(false);
    mImageView02.setEnabled(false);
    mImageView03.setEnabled(false);
  }

  /**
   * 重新洗牌的程序
   */
  private void random() {
    for (int i = 0; i < 3; i++) {
      int tmp = s1[i];
      int s = (int) (Math.random() * 2);
      s1[i] = s1[s];
      s1[s] = tmp;
    }
  }
}
