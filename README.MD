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
