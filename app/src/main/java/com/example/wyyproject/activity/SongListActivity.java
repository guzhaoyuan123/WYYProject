package com.example.wyyproject.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.wyyproject.R;
import com.example.wyyproject.adapter.MainFragmentAdapter;
import com.example.wyyproject.musicfragment.ChineseFragment;
import com.example.wyyproject.musicfragment.FashionFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class SongListActivity extends AppCompatActivity {


    private ImageView imageView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        tabLayout = findViewById(R.id.songlist_tab_layout);
        viewPager = findViewById(R.id.songlist_fl_monetary_replace);
        imageView = findViewById(R.id.songlist_img_fanhui);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SongListActivity.this.finish();
            }
        });
        initPager();
    }



    private void initPager() {
        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("官方");
        titles.add("精品");
        titles.add("华语");
        titles.add("流行");
        titles.add("民谣");
        titles.add("电子");
        titles.add("轻音乐");

        List<Fragment> fragments = new ArrayList<>();
        for (String title : titles){
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }
        fragments.add(new ChineseFragment());
        fragments.add(new FashionFragment());
        fragments.add(new ChineseFragment());
        fragments.add(new FashionFragment());
        fragments.add(new ChineseFragment());
        fragments.add(new FashionFragment());
        fragments.add(new ChineseFragment());
        fragments.add(new FashionFragment());

        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

}
