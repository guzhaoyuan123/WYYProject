package com.example.wyyproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.example.url.guanfangbandan.GuanFangBangDanApi;
import com.example.url.guanfangbandan.ListBean;
import com.example.wyyproject.R;
import com.example.wyyproject.adapter.TopListGuanFangRecyclerviewAdapter;
import com.example.wyyproject.adapter.TopListTuijianRecyclerviewAdapter;
import com.example.wyyproject.list.MusicTopActivity;
import com.example.wyyproject.util.Http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TopListActivity extends AppCompatActivity {

    @BindView(R.id.songlist_img_fanhui)
    ImageView songlistImgFanhui;
    @BindView(R.id.toplist_recyclr_guanfang)
    RecyclerView toplistRecyclrGuanfang;
    @BindView(R.id.toplist_recyclr_tuijianbang)
    RecyclerView toplistRecyclrTuijianbang;
    @BindView(R.id.toplist_recyclr_quanqiubang)
    RecyclerView toplistRecyclrQuanqiubang;
    @BindView(R.id.toplist_recyclr_gengduobangdan)
    RecyclerView toplistRecyclrGengduobangdan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_list);
        ButterKnife.bind(this);
        stagger();//官方榜单
        stagger2();//推荐榜单
        stagger3();//全球榜单
        stagger4();//更多榜单
        initView();
    }

    private void initView() {

    }

    private void stagger() {//官方榜单
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/toplist/detail");
                    Log.e("&&&&&&&&&&&&&&&&",""+json);
                    GuanFangBangDanApi api = JSON.parseObject(json, GuanFangBangDanApi.class);
                    List<ListBean> result = api.getList();
                    List<ListBean> result2=new ArrayList<>();
                    result2.add(result.get(0));
                    result2.add(result.get(1));
                    result2.add(result.get(2));
                    result2.add(result.get(3));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showTuiJianGeDan(result2);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //展示官方榜单
    private void showTuiJianGeDan(List<ListBean> result) {
        toplistRecyclrGuanfang.setLayoutManager(new LinearLayoutManager(this));
        TopListGuanFangRecyclerviewAdapter adapter = new TopListGuanFangRecyclerviewAdapter(this, result);
        toplistRecyclrGuanfang.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new TopListGuanFangRecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(TopListActivity.this, MusicTopActivity.class);
                intent.putExtra("paihangbangId",result.get(position).getId());
                intent.putExtra("paihangbangName",result.get(position).getName());
                startActivity(intent);
            }
        });
    }



    private void stagger2() {//推荐榜单
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/toplist/detail");
                    Log.e("&&&&&&&&&&&&&&&&",""+json);
                    GuanFangBangDanApi api = JSON.parseObject(json, GuanFangBangDanApi.class);
                    List<ListBean> result = api.getList();
                    List<ListBean> result2=new ArrayList<>();
                    result2.add(result.get(4));
                    result2.add(result.get(5));
                    result2.add(result.get(6));
                    result2.add(result.get(7));
                    result2.add(result.get(8));
                    result2.add(result.get(9));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showTuiJianBangdan(result2);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //展示推荐榜单
    private void showTuiJianBangdan(List<ListBean> result) {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        toplistRecyclrTuijianbang.setLayoutManager(layoutManager);

        TopListTuijianRecyclerviewAdapter adapter = new TopListTuijianRecyclerviewAdapter(this, result);
        toplistRecyclrTuijianbang.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new TopListTuijianRecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(TopListActivity.this,MusicTopActivity.class);
                intent.putExtra("paihangbangId",result.get(position).getId());
                intent.putExtra("paihangbangName",result.get(position).getName());
                startActivity(intent);
            }
        });
    }

    private void stagger3() {//全球榜单
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/toplist/detail");
                    Log.e("&&&&&&&&&&&&&&&&",""+json);
                    GuanFangBangDanApi api = JSON.parseObject(json, GuanFangBangDanApi.class);
                    List<ListBean> result = api.getList();
                    List<ListBean> result2=new ArrayList<>();
                    result2.add(result.get(10));
                    result2.add(result.get(11));
                    result2.add(result.get(12));
                    result2.add(result.get(13));
                    result2.add(result.get(14));
                    result2.add(result.get(15));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showQuanQiuBangdan(result2);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //展示全球榜单
    private void showQuanQiuBangdan(List<ListBean> result) {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        toplistRecyclrQuanqiubang.setLayoutManager(layoutManager);

        TopListTuijianRecyclerviewAdapter adapter = new TopListTuijianRecyclerviewAdapter(this, result);
        toplistRecyclrQuanqiubang.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new TopListTuijianRecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(TopListActivity.this,MusicTopActivity.class);
                intent.putExtra("paihangbangId",result.get(position).getId());
                intent.putExtra("paihangbangName",result.get(position).getName());
                startActivity(intent);
            }
        });
    }


    private void stagger4() {//更多榜单
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/toplist/detail");
                    Log.e("&&&&&&&&&&&&&&&&",""+json);
                    GuanFangBangDanApi api = JSON.parseObject(json, GuanFangBangDanApi.class);
                    List<ListBean> result = api.getList();
                    List<ListBean> result2=new ArrayList<>();
                    for (int i=11;i<result.size();i++){
                        result2.add(result.get(i));
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showGengDuoBangdan(result2);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //展示更多榜单
    private void showGengDuoBangdan(List<ListBean> result) {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        toplistRecyclrGengduobangdan.setLayoutManager(layoutManager);

        TopListTuijianRecyclerviewAdapter adapter = new TopListTuijianRecyclerviewAdapter(this, result);
        toplistRecyclrGengduobangdan.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new TopListTuijianRecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(TopListActivity.this,MusicTopActivity.class);
                intent.putExtra("paihangbangId",result.get(position).getId());
                intent.putExtra("paihangbangName",result.get(position).getName());
                startActivity(intent);
            }
        });
    }




    @OnClick(R.id.songlist_img_fanhui)
    public void onViewClicked() {
        TopListActivity.this.finish();
    }
}
