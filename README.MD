# FragmentTabhost


When using FragmentTabhost, you can set up onTabChanged before onTabClick.


## Import

Maven

    <dependency>
      <groupId>com.lyl.tabhost</groupId>
      <artifactId>tabhost</artifactId>
      <version>1.0.0</version>
      <type>pom</type>
    </dependency>

Gradle

    dependencies {
        compile 'com.lyl.tabhost:tabhost:1.0.0'
    }

## Usage

Add activity_main.xml **(FragmentTabHost must android:id="@android:id/tabhost" )**：

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout
        android:id="@+id/activity_main"
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <FrameLayout
            android:id="@+id/main_content"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"/>

        <com.lyl.tabhost.FragmentTabHost
            android:id="@android:id/tabhost"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">
        </com.lyl.tabhost.FragmentTabHost>
    </LinearLayout>


Set setOnTabClickListener for FragmentTabHost：

    // you can set up onTabChanged before onTabClick.
    mFragmentTabHost.setOnTabClickListener(new FragmentTabHost.OnTabClickListener() {
        @Override
        public boolean onTabClick(String tabId) {
            if ("setting".equals(tabId)) {
                Toast.makeText(MainActivity.this, "Be intercepted, do not jump", Toast.LENGTH_LONG).show();
                return true;
            }

            return false;
        }
    });

    // Prior to this time, the first implementation of the above setOnTabClickListener monitor
    mFragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
        @Override
        public void onTabChanged(String s) {
            getSupportActionBar().setTitle(s);
        }
    });


## License

    Copyright 2016 Wing-Li

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
