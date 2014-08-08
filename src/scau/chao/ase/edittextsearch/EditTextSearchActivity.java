package scau.chao.ase.edittextsearch;

import scau.chao.ase.R;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * 通过输入关键字在短信息数据库中查找有关键字的短消息 需要读短消息的权限<uses-permission android:name="android.permission.READ_SMS"
 * 
 * @author 蔡超敏
 * 
 */
public class EditTextSearchActivity extends ActionBarActivity {

  Button bu;// 查询按钮
  EditText et;// 输入框
  ListView lv;// 用于显示查询结果的列表

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit_text_search);

    bu = (Button) findViewById(R.id.button1);
    et = (EditText) findViewById(R.id.editText1);
    lv = (ListView) findViewById(R.id.listView1);
    bu.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        String key = et.getText().toString();
        // 查询sms数据库的address和body两列，即信息发送者和信息内容，使用SimpleCursorAdapter必须要有_id列
        Cursor c =
            getContentResolver().query(Uri.parse("content://sms"),
                new String[] {"_id", "address", "body"},
                // 通过where body like %key%进行模糊查询
                "body like ?", new String[] {"%" + key + "%"}, null);
        // SimpleCursorAdapter适配器
        SimpleCursorAdapter sim =
            new SimpleCursorAdapter(EditTextSearchActivity.this,
                android.R.layout.simple_list_item_2, c, new String[] {"address", "body"},
                new int[] {android.R.id.text1, android.R.id.text2});
        lv.setAdapter(sim);
      }
    });


  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.edit_text_search, menu);
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
