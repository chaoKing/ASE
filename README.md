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
