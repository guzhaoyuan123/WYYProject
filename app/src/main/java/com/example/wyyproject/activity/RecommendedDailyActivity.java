package com.example.wyyproject.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.wyyproject.R;
import com.example.wyyproject.adapter.EveryDayTuiJianAdapter;
import com.example.wyyproject.util.AppBarStateChangeListener;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class RecommendedDailyActivity extends AppCompatActivity {

    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private ListView listView;
    private Menu id;

    private List<String> titles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_daily);
        toolbar = findViewById(R.id.toolbar);

        id=findViewById(R.id.menu_add);

        appBarLayout = findViewById(R.id.appbar);

        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if( state == State.EXPANDED ) {
                    //展开状态
                    toolbar.setNavigationIcon(R.mipmap.return2);
                }else if(state == State.COLLAPSED){
                    //折叠状态
                    toolbar.setNavigationIcon(R.mipmap.return2);

                    toolbar.setTitleTextColor(Color.WHITE);
                    toolbar.setTitle("每日推荐");
                }else {
                    //中间状态
                    toolbar.setNavigationIcon(R.mipmap.return2);
                }
            }
        });

        titles = new ArrayList<>();
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
        titles.add("青少年模式");
        titles.add("青少年模式");
        titles.add("青少年模式");
        titles.add("青少年模式");
        titles.add("青少年模式");


        listView=findViewById(R.id.listVIew);
        EveryDayTuiJianAdapter adapter = new EveryDayTuiJianAdapter(this, titles);
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
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




    //创建选项菜单OptionMenu
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.talk, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //        处理选项菜单的点击事件


}
