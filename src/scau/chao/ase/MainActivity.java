/**
 * Copyright (c) 广州顶九信息技术有限公司 2014 版权所有
 * 
 * 文件创建时间：2014-8-7
 */
package scau.chao.ase;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * 软件主界面
 * 
 * @author 蔡超敏
 * 
 */
public class MainActivity extends ActionBarActivity {

  private ListView listView;

  private static final String[] strings = new String[] {"four", "five"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listView = (ListView) findViewById(R.id.showListView);

    listView
        .setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings));


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
