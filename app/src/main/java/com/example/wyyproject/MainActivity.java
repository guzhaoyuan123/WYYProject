package com.example.wyyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.example.wyyproject.fragment.FindFragment;
import com.example.wyyproject.fragment.MeFragment;
import com.example.wyyproject.fragment.VideoFragment;
import com.example.wyyproject.fragment.VillageFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Fragment blank;
    private Fragment blank1;
    private Fragment blank2;
    private Fragment blank3;
    private Fragment testblank;

    private TabLayout tabLayout;

    private ViewPager viewPager;
    private List<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        switchFragment(blank1).commit();
    }

    private void initView() {
        testblank = new FindFragment();
        blank = new MeFragment();
        blank1 = new FindFragment();
        blank2 = new VillageFragment();
        blank3 = new VideoFragment();
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("我的"));
        tabLayout.addTab(tabLayout.newTab().setText("发现"));
        tabLayout.addTab(tabLayout.newTab().setText("云村"));
        tabLayout.addTab(tabLayout.newTab().setText("视频"));
        //默认七日收益
        //默认七日收益
        tabLayout.getTabAt(1).select();
        initListener();
    }

    private void initListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    switchFragment(blank).commit();
                }
                if (tab.getPosition() == 1) {
                     switchFragment(blank1).commit();
                }
                if (tab.getPosition() == 2) {
                   switchFragment(blank2).commit();
                }
                if (tab.getPosition() == 3) {
                   switchFragment(blank3).commit();
                }

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



    private FragmentTransaction switchFragment(Fragment targerFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!targerFragment.isAdded()) {
            //未加载过
            transaction.hide(testblank);//隐藏默认Fragment
            transaction.add(R.id.fl_monetary_replace, targerFragment, targerFragment.getClass().getName());//添加
        } else {
            //加载过
            transaction.hide(testblank);//隐藏默认
            transaction.show(targerFragment);//加载现在
        }
        testblank = targerFragment;
        return transaction;
    }

}