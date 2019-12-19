package com.example.wyyproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.url.meirituijian.EveryDaygeApi;
import com.example.url.meirituijian.PlaylistBean;
import com.example.url.meirituijian.TracksBean;
import com.example.wyyproject.R;
import com.example.wyyproject.adapter.EveryDayTuiJianAdapter;
import com.example.wyyproject.util.AppBarStateChangeListener;
import com.example.wyyproject.util.Http;
import com.google.android.material.appbar.AppBarLayout;

import java.io.IOException;
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
        appBarLayout = findViewById(R.id.appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if( state == State.EXPANDED ) {
                    //展开状态
                    toolbar.setNavigationIcon(R.mipmap.return2);
                    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            RecommendedDailyActivity.this.finish();
                        }
                    });

                }else if(state == State.COLLAPSED){
                    //折叠状态
                    toolbar.setNavigationIcon(R.mipmap.return2);
                    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            RecommendedDailyActivity.this.finish();
                        }
                    });

                }else {
                    //中间状态
                    toolbar.setNavigationIcon(R.mipmap.return2);
                    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            RecommendedDailyActivity.this.finish();
                        }
                    });
                }
            }
        });

        setSupportActionBar(toolbar);
        listView=findViewById(R.id.listVIew);
        initView();

    }
    //加载新歌
    private void initView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/top/list?idx=1");
                    Log.e(">>>>>>",""+json);
                    EveryDaygeApi api = JSON.parseObject(json, EveryDaygeApi.class);

                    PlaylistBean beans = api.getPlaylist();
                    List<TracksBean> tracksBeans = beans.getTracks();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showXin(tracksBeans);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showXin(List<TracksBean> beans) {
        EveryDayTuiJianAdapter adapter = new EveryDayTuiJianAdapter(this, beans);
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(RecommendedDailyActivity.this,MusicActivity.class);
                intent.putExtra("musicZuozhe",beans.get(i).getAr().get(0).getName());
                intent.putExtra("musicPicture",beans.get(i).getAl().getPicUrl());
                intent.putExtra("musicName",beans.get(i).getName());
                intent.putExtra("musicId",beans.get(i).getId());
                startActivity(intent);
            }
        });
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.wenti:
                Intent intent = new Intent(RecommendedDailyActivity.this,TroubleShootingActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }


}
