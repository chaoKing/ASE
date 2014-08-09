ASE
===
1.定义控件样式。

步骤：

a.写样式。

格式：

  <style name=string [parent=string]>
  
    <item name=string>Hwx value | string value | reference</item>
    
  </style>
  
例子：

  <resources>
  
      <!--
          Base application theme, dependent on API level. This theme is replaced
          by AppBaseTheme from res/values-vXX/styles.xml on newer devices.
      -->
      <style name="AppBaseTheme" parent="Theme.AppCompat.Light">
      
          <!--
              Theme customizations available in newer API levels can go in
              res/values-vXX/styles.xml, while customizations related to
              backward-compatibility can go here.
          -->
          
      </style>
      
      <!-- Application theme. -->
      
      <style name="AppTheme" parent="AppBaseTheme">
      
          <!-- All customizations that are NOT specific to a particular API-level can go here. -->
          
      </style>
      
  </resources>
  
b.控件上引用就行了。

格式：

  style="@style/样式名"
  
2.ImageButton的设置透明度的问题。

【1】3.0以下版本,不支持setalpha, 且不支持在xml文件中设置android:alpha = "0.5"这种方法(如果xml中设置则一律是不透明的);

【2】3.0以下版本, 在xml中配置透明度,只能通过ARGB设置.,如background="#0123"

【3】3.0以下版本通过以下2种方式：

  a：view.getBackground().setAlpha(255)这种方法设置;
  
  b:通过这种方法设置时,xml中的view的background只能设置RGB,不能是ARGB的格式
  
