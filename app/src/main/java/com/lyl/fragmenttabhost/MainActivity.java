package com.lyl.fragmenttabhost;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.lyl.tabhost.FragmentTabHost;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mFragmentTabHost;

    private ArrayList<String> mFragmentTitles;
    private ArrayList<Class> mFragmentLists;
    private ArrayList<Integer> mFragmentResIds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }


    private void initData() {
        mFragmentTitles = new ArrayList<String>();
        mFragmentTitles.add("首页");
        mFragmentTitles.add("消息");
        mFragmentTitles.add("WingLi");
        mFragmentTitles.add("关于");

        mFragmentLists = new ArrayList<>();
        mFragmentLists.add(BlankFragment.newInstance("首页").getClass());
        mFragmentLists.add(BlankFragment.newInstance("消息").getClass());
        mFragmentLists.add(BlankFragment.newInstance("WingLi").getClass());
        mFragmentLists.add(BlankFragment.newInstance("关于").getClass());

        mFragmentResIds = new ArrayList<>();
        mFragmentResIds.add(R.drawable.tab_hometop_btn);
        mFragmentResIds.add(R.drawable.tab_msgtop_btn);
        mFragmentResIds.add(R.drawable.tab_opentop_btn);
        mFragmentResIds.add(R.drawable.tab_abouttop_btn);
    }


    private void initView() {
        mFragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mFragmentTabHost.setup(this, getSupportFragmentManager(), R.id.main_content);

        int count = mFragmentTitles.size();
        TabHost.TabSpec tabSpec;
        for (int i = 0; i < count; i++) {
            tabSpec = mFragmentTabHost.newTabSpec(mFragmentTitles.get(i)).setIndicator(getTabView(i));
            mFragmentTabHost.addTab(tabSpec, mFragmentLists.get(i), null);
        }

        mFragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                getSupportActionBar().setTitle(s);
            }
        });

        // 添加了点击事件
        // 每点击一个 Tab 都会触发这个点击事件，
        // true：表示不继续执行；
        // false：父类继续执行，继续执行 OnTabChangeListener；
        mFragmentTabHost.setOnTabClickListener(new FragmentTabHost.OnTabClickListener() {
            @Override
            public boolean onTabClick(String tabId) {
                if ("WingLi".equals(tabId)) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.jianshu.com/u/320f9e8f7fc9"));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "跳转到另一个APP。", Toast.LENGTH_LONG).show();
                    return true;
                }

                return false;
            }
        });

    }


    private View getTabView(int i) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_item_view, null);
        ImageView img = (ImageView) view.findViewById(R.id.tab_item_img);
        TextView txt = (TextView) view.findViewById(R.id.tab_item_txt);

        img.setImageResource(mFragmentResIds.get(i));
        txt.setText(mFragmentTitles.get(i));
        return view;
    }
}
