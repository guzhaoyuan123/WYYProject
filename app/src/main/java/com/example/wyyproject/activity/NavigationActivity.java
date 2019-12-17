package com.example.wyyproject.activity;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wyyproject.R;
import com.example.wyyproject.adapter.MainFragmentAdapter;
import com.example.wyyproject.adapter.NavigationListAdapter;
import com.example.wyyproject.fragment.FindFragment;
import com.example.wyyproject.fragment.MeFragment;
import com.example.wyyproject.fragment.VideoFragment;
import com.example.wyyproject.fragment.VillageFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.img_navigation_touxiang)
    RoundedImageView imgNavigationTouxiang;
    @BindView(R.id.tx_navigation_nicname)
    TextView txNavigationNicname;
    @BindView(R.id.btn_navigation_qiandao)
    Button btnNavigationQiandao;
    @BindView(R.id.img_navigation_wodexiaoxi)
    ImageView imgNavigationWodexiaoxi;
    @BindView(R.id.img_navigation_wodehaoyou)
    ImageView imgNavigationWodehaoyou;
    @BindView(R.id.img_navigation_tinggeshiqu)
    ImageView imgNavigationTinggeshiqu;
    @BindView(R.id.img_navigation_gexingzhuangban)
    ImageView imgNavigationGexingzhuangban;
    @BindView(R.id.Navigation_listview)
    ListView NavigationListview;
    @BindView(R.id.img_navigation_yejianmoshi)
    ImageView imgNavigationYejianmoshi;
    @BindView(R.id.img_navigation_shezhi)
    ImageView imgNavigationShezhi;
    @BindView(R.id.img_navigation_tuichu)
    ImageView imgNavigationTuichu;
    @BindView(R.id.nav_view)
    NavigationView navView;

    private RoundedImageView imageView;

    private AppBarLayout appBarLayout;
    private SwipeRefreshLayout refreshLayout;
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

    private List<String> titles = new ArrayList<>();
    private List<Integer> heads= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ButterKnife.bind(this);

        imageView=findViewById(R.id.img_navigation_touxiang);
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
        refreshLayout=findViewById(R.id.refreshLayout);

        initView();

        initPager();

    }

    private void initView() {
        titles= new ArrayList<>();
        titles.add("演出");
        titles.add("商城");
        titles.add("附近的人");
        titles.add("游戏推荐");
        titles.add("口袋彩铃");
        titles.add("创作者中心");
        titles.add("我的订单");
        titles.add("定时停止播放");
        titles.add("扫一扫");
        titles.add("音乐闹钟");
        titles.add("音乐云盘");
        titles.add("在线听歌免流量");
        titles.add("优惠券");
        titles.add("青少年模式");

        heads= new ArrayList<>();
        heads.add(R.mipmap.cebianlan_yanchu);
        heads.add(R.mipmap.cebianlan_shangcheng );
        heads.add(R.mipmap.cebianlan_fujin);
        heads.add(R.mipmap.cebianlan_youxi);
        heads.add(R.mipmap.cebianlan_koudai);
        heads.add(R.mipmap.cebianlan_chuangzuozhe);
        heads.add(R.mipmap.cebianlan_wodedingdan);
        heads.add(R.mipmap.cebianlan_dingshi);
        heads.add(R.mipmap.cebianlan_saoyisao);
        heads.add(R.mipmap.cebianlan_yinyuenaozhong);
        heads.add(R.mipmap.cebianlan_yunpan);
        heads.add(R.mipmap.cebianlan_zaixian);
        heads.add(R.mipmap.cebianlan_youhuiquan);
        heads.add(R.mipmap.cebianlan_qinshaonian);
        Log.e("","??????????"+titles.size()+"?????????????????"+heads.size());

        NavigationListAdapter adapter = new NavigationListAdapter(this,titles,heads);
        NavigationListview.setAdapter(adapter);


        fixListViewHeight(NavigationListview);
    }

    public void fixListViewHeight(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        ListAdapter listAdapter = listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }
        for (int index = 0, len = listAdapter.getCount(); index < len; index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }



    private void initPager() {
        List<String> titles = new ArrayList<>();
        titles.add("我的");
        titles.add("发现");
        titles.add("云村");
        titles.add("视频");

        List<Fragment> fragments = new ArrayList<>();
        for (String title : titles) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }
        fragments.add(new MeFragment());
        fragments.add(new FindFragment());
        fragments.add(new VillageFragment());
        fragments.add(new VideoFragment());

        Log.e(">>>>>>>>>>", "" + fragments.size());
        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(1).select();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView textView = new TextView(NavigationActivity.this);
                float selectedSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 22, getResources().getDisplayMetrics());
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, selectedSize);
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
                Toast.makeText(NavigationActivity.this, "无敌帮帮糖", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_gallery:
                Toast.makeText(NavigationActivity.this, "无敌帮帮糖2", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_manage:
                Toast.makeText(NavigationActivity.this, "无敌帮帮糖3", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_send:
                Toast.makeText(NavigationActivity.this, "无敌帮帮糖4", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_share:
                Toast.makeText(NavigationActivity.this, "无敌帮帮糖5", Toast.LENGTH_LONG).show();
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
