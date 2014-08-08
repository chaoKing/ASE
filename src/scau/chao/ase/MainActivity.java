/**
 * Copyright (c) 华楠农业大学蔡超敏 2014 版权所有
 * 
 * 文件创建时间：2014-8-7
 */
package scau.chao.ase;

import scau.chao.ase.autocompletetext.AutoCompleteTextActivity;
import scau.chao.ase.dragimage.DragImageActivity;
import scau.chao.ase.edittextsearch.EditTextSearchActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * 
 * 软件主界面
 * 
 * @author 蔡超敏
 * 
 */
public class MainActivity extends ActionBarActivity {

  private ListView listView;

  private static final String[] STRINGS = new String[] {"Drag Image Gallery", "Choose Dialog",
      "Check EditText", "Auto Complete Text"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listView = (ListView) findViewById(R.id.showListView);

    listView
        .setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, STRINGS));

    listView.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("listView", "position = " + position);
        switch (position) {
          case 0:
            goToTheFirstExample();
            break;
          case 1:
            goToTheSecondExample();
            break;
          case 2:
            goToTheThirdExample();
            break;
          case 3:
            goToTheFourthExample();
            break;
          default:
            break;
        }

      }

    });
  }

  /**
   * 拖拉图片例子
   */
  private void goToTheFirstExample() {
    Intent intent = new Intent(this, DragImageActivity.class);
    startActivity(intent);
  }

  private static final String[] ALERTDAILOG_STRING = new String[] {"Apple", "Banana", "Bullace",
      "Coconut", "Date", "Durian", "Haw", "Honey-dew melon", "Juicy peach", "Kernel fruit",
      "Cherry"};

  /**
   * AlertDialog.Builder
   */
  private void goToTheSecondExample() {
    new AlertDialog.Builder(this).setTitle("choose your need!")
        .setItems(ALERTDAILOG_STRING, new OnClickListener() {

          @Override
          public void onClick(DialogInterface dialog, int which) {
            new AlertDialog.Builder(MainActivity.this)
                .setMessage("your need is " + ALERTDAILOG_STRING[which])
                .setNeutralButton("OK", new OnClickListener() {

                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "ok~~~", Toast.LENGTH_LONG).show();
                  }
                }).show();
          }
        }).setNegativeButton("cancel", new OnClickListener() {

          @Override
          public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        }).show();
  }



  /**
   * EditText的预编写及预判
   */
  private void goToTheThirdExample() {
    Intent intent = new Intent(this, EditTextSearchActivity.class);
    startActivity(intent);
  }


  /**
   * 自动提示补充text
   */
  private void goToTheFourthExample() {
    Intent intent = new Intent(this, AutoCompleteTextActivity.class);
    startActivity(intent);
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }


}
