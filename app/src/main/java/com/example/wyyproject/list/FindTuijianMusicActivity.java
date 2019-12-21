package com.example.wyyproject.list;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.url.paihangbang2.FindTuiJianListApi;
import com.example.url.paihangbang2.TracksBean;
import com.example.wyyproject.R;
import com.example.wyyproject.activity.TroubleShootingActivity;
import com.example.wyyproject.adapter.FindTuijianListAdapter;
import com.example.wyyproject.changpian.FindTuijianActivity;
import com.example.wyyproject.util.AppBarStateChangeListener;
import com.example.wyyproject.util.FindTuiJianCommon;
import com.example.wyyproject.util.Http;
import com.google.android.material.appbar.AppBarLayout;

import java.io.IOException;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FindTuijianMusicActivity extends AppCompatActivity {
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_tui_jian_music);

        Intent intent = getIntent();
        long id = intent.getLongExtra("paihangbangId2",0);
        Log.e(">>>>>>",""+id);
        String name=intent.getStringExtra("paihangbangName2");

        toolbar = findViewById(R.id.toolbar3);
        toolbar.setTitle(name);
        toolbar.setTitleTextColor(Color.WHITE);
        appBarLayout = findViewById(R.id.appbar3);
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, AppBarStateChangeListener.State state) {
            }
        });

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
        listView=findViewById(R.id.listVIew3);
        initView(id);

    }
    //加载新歌
    private void initView(long id) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/playlist/detail?id=2967801365");
                    Log.e(">>>>>>",""+json+id);
                    FindTuiJianListApi api = JSON.parseObject(json, FindTuiJianListApi.class);
                    List<TracksBean> tracksBeans = api.getPlaylist().getTracks();
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

    private void showXin( List<TracksBean> beans) {
        FindTuijianListAdapter adapter = new FindTuijianListAdapter(this, beans);
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
        FindTuiJianCommon.musicList=beans;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(FindTuijianMusicActivity.this, FindTuijianActivity.class);
                intent.putExtra("postion",i);
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
                Intent intent = new Intent(FindTuijianMusicActivity.this, TroubleShootingActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }


}
