package scau.chao.ase.autocompletetext;

import scau.chao.ase.R;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoCompleteTextActivity extends ActionBarActivity {

  final String[] COUNTRIES = {"China", "Cuba", "Costa Rica",

  "Columbia", "Chizen", "Canada", "America",

  "Africa", "Belgium", "India"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_auto_complete_text);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,

    android.R.layout.simple_dropdown_item_1line,

    COUNTRIES);



    AutoCompleteTextView text = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

    text.setAdapter(adapter);



    // 获取 MultiAutoCompleteTextView 对象 text

    MultiAutoCompleteTextView mtext =

    (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);

    // 依然使用前面构造好的 ArrayAdapter 对象

    mtext.setAdapter(adapter);

    // 指定分隔符 ”,”

    mtext.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.auto_complete_text, menu);
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
