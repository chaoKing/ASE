/**
 * Copyright (c) 华楠农业大学蔡超敏 2014 版权所有
 * 
 * 文件创建时间：2014-8-8
 */
package scau.chao.ase.appwidgetprovider;

import java.sql.Date;
import java.text.SimpleDateFormat;

import scau.chao.ase.R;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

/**
 * 未完成
 * 
 * @author 蔡超敏
 *
 */
public class MyUpdateWidgetService extends Service {
  public MyUpdateWidgetService() {}

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  @Deprecated
  public void onStart(Intent intent, int startId) {
    super.onStart(intent, startId);
    /* 取得Widget的View */
    RemoteViews updateViews = new RemoteViews(this.getPackageName(), R.layout.my_widget_provider);
    /* 格式化时间hh:mm占表时跟分 */
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
    /* 将时间放置TextView */
    updateViews.setTextViewText(R.id.appwidget_text,
        "" + sdf.format(new Date(System.currentTimeMillis())));

    /* 更新widget */
    ComponentName thisWidget = new ComponentName(this, MyWidgetProvider.class);
    AppWidgetManager manager = AppWidgetManager.getInstance(this);
    manager.updateAppWidget(thisWidget, updateViews);
  }


}
