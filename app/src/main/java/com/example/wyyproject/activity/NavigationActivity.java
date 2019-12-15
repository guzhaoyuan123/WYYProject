package com.example.wyyproject.activity;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wyyproject.R;
import com.example.wyyproject.adapter.MainFragmentAdapter;
import com.example.wyyproject.fragment.FindFragment;
import com.example.wyyproject.fragment.MeFragment;
import com.example.wyyproject.fragment.VideoFragment;
import com.example.wyyproject.fragment.VillageFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment blank;
    private Fragment blank1;
    private Fragment blank2;
    private Fragment blank3;
    private Fragment testblank;

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        toolbar = findViewById(R.id.tool_barT);
        setSupportActionBar(toolbar);

        //        难难难
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
//        难难难


        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.fl_monetary_replace);
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
                TextView textView = new TextView(NavigationActivity.this);
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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_camera:
                Toast.makeText(NavigationActivity.this,"无敌帮帮糖",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_gallery:
                Toast.makeText(NavigationActivity.this,"无敌帮帮糖2",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_manage:
                Toast.makeText(NavigationActivity.this,"无敌帮帮糖3",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_send:
                Toast.makeText(NavigationActivity.this,"无敌帮帮糖4",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_share:
                Toast.makeText(NavigationActivity.this,"无敌帮帮糖5",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
