package com.example.wyyproject;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;

import com.example.wyyproject.adapter.MainFragmentAdapter;
import com.example.wyyproject.fragment.FindFragment;
import com.example.wyyproject.fragment.MeFragment;
import com.example.wyyproject.fragment.VideoFragment;
import com.example.wyyproject.fragment.VillageFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private Fragment blank;
    private Fragment blank1;
    private Fragment blank2;
    private Fragment blank3;
    private Fragment testblank;

    private TabLayout tabLayout;

    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.fl_monetary_replace);
        toolbar = findViewById(R.id.tool_barT);
        setSupportActionBar(toolbar);
        initPager();
    }



    private void initPager() {
        List<String> titles = new ArrayList<>();
        titles.add("我的");
        titles.add("发现");
        titles.add("云村");
        titles.add("视频");

        List<Fragment> fragments = new ArrayList<>();
        for (String title : titles){
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }
        fragments.add(new MeFragment());
        fragments.add(new FindFragment());
        fragments.add(new VillageFragment());
        fragments.add(new VideoFragment());

        Log.e(">>>>>>>>>>",""+fragments.size());
        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(1).select();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView textView = new TextView(MainActivity.this);
                float selectedSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 22, getResources().getDisplayMetrics());
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,selectedSize);
                textView.setTextColor(getResources().getColor(R.color.selectCheck2));
                textView.setText(tab.getText());
                tab.setCustomView(textView);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setCustomView(null);
            }


            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }



}