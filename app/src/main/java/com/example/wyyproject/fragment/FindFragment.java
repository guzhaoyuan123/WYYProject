package com.example.wyyproject.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.url.banner.BannersApi;
import com.example.url.shipingdizhileixing.DataBean;
import com.example.url.shipingdizhileixing.ShiPingDiZhiApi;
import com.example.url.tuijiangedan.RecommendThePlayList;
import com.example.url.tuijiangedan.ResultBean;
import com.example.url.xindie.AlbumsBean;
import com.example.url.xindie.TheNewDisc;
import com.example.url.yuncunjingxuanshiping.YunCunJingXuanSHiPing;
import com.example.wyyproject.R;
import com.example.wyyproject.activity.VillageOfSelectedActivity;
import com.example.wyyproject.adapter.FindTJGDRecyclerviewAdapter;
import com.example.wyyproject.adapter.FindXDRecyclerviewAdapter;
import com.example.wyyproject.adapter.FindYCJXRecyclerviewAdapter;
import com.example.wyyproject.util.AdViewpagerUtil;
import com.example.wyyproject.util.Http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {
    private ViewPager viewpager;
    private RecyclerView find_recyclerView_tuijianedan;
    private RecyclerView find_recyclerView_xindie, find_recyclerView_yuncunjingxuan;
    private LinearLayout lydots;

    private static String[] urls, titles;
    private AdViewpagerUtil adViewpagerUtil;
    private TextView bannerText, textView1, textView2;

    private Button btn_find_xin;
    private SwipeRefreshLayout refreshLayout;

    public FindFragment() {

    }


    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();

        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_find, container, false);
        bannerText = view.findViewById(R.id.banner_text);
        viewpager = view.findViewById(R.id.viewpager);
        lydots = view.findViewById(R.id.ly_dots);
        refreshLayout = view.findViewById(R.id.refreshLayout);
        textView1 = view.findViewById(R.id.tx_find_xindie);
        textView2 = view.findViewById(R.id.tx_find_xinge);
        btn_find_xin = view.findViewById(R.id.btn_find_xin);
        find_recyclerView_yuncunjingxuan = view.findViewById(R.id.find_recyclerView_yuncunjingxuan);

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(
                android.R.color.holo_red_light,
                android.R.color.holo_red_light,
                android.R.color.holo_red_light,
                android.R.color.holo_red_light);

        find_recyclerView_xindie = view.findViewById(R.id.find_recyclerView_xindie);
        find_recyclerView_tuijianedan = view.findViewById(R.id.find_recyclerView_tuijianedan);
        stagger4();
        stagger2();
        stagger();


        initView();
        jiazai();

        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        return view;
    }

    private void initView() {


    }

    ///
//加载推荐歌单
    private void stagger() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/personalized?limit=6");
                    RecommendThePlayList recommendThePlayList = JSON.parseObject(json, RecommendThePlayList.class);
                    List<ResultBean> result = recommendThePlayList.getResult();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showTuiJianGeDan(result);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //展示推荐歌单
    private void showTuiJianGeDan(List<ResultBean> result) {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        find_recyclerView_tuijianedan.setLayoutManager(layoutManager);


        // recyclerView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));

        FindTJGDRecyclerviewAdapter adapter = new FindTJGDRecyclerviewAdapter(getContext(), result);
        find_recyclerView_tuijianedan.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new FindTJGDRecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(), "haole", Toast.LENGTH_LONG).show();
            }
        });
    }

    ///
//加载新碟
    private void stagger2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/album/newest");
                    TheNewDisc theNewDisc = JSON.parseObject(json, TheNewDisc.class);
                    List<AlbumsBean> albums = theNewDisc.getAlbums();
                    List<AlbumsBean> albumsBeans = new ArrayList<>();
                    albumsBeans.add(albums.get(0));
                    albumsBeans.add(albums.get(1));
                    albumsBeans.add(albums.get(2));

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showXindie(albumsBeans);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //展示新碟XinDie
    private void showXindie(final List<AlbumsBean> albums) {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        find_recyclerView_xindie.setLayoutManager(layoutManager);
        FindXDRecyclerviewAdapter adapter = new FindXDRecyclerviewAdapter(getContext(), albums);
        find_recyclerView_xindie.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new FindXDRecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(), "haole", Toast.LENGTH_LONG).show();
            }
        });
    }

    //加载新歌
    private void stagger3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/album/newest");
                    TheNewDisc theNewDisc = JSON.parseObject(json, TheNewDisc.class);
                    List<AlbumsBean> albums = theNewDisc.getAlbums();
                    List<AlbumsBean> albumsBeans = new ArrayList<>();
                    albumsBeans.add(albums.get(4));
                    albumsBeans.add(albums.get(5));
                    albumsBeans.add(albums.get(6));

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showXin(albumsBeans);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //展示新歌
    private void showXin(final List<AlbumsBean> albums) {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        find_recyclerView_xindie.setLayoutManager(layoutManager);
        FindXDRecyclerviewAdapter adapter = new FindXDRecyclerviewAdapter(getContext(), albums);
        find_recyclerView_xindie.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new FindXDRecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(), "haole", Toast.LENGTH_LONG).show();
            }
        });
    }

    //加载云村经典
    private void stagger4() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/top/mv?limit=30");
                    Log.e("????????????", "" + json);
                    ShiPingDiZhiApi shiPingDiZhiApi = JSON.parseObject(json, ShiPingDiZhiApi.class);
                   List<DataBean> datasBeans = shiPingDiZhiApi.getData();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showYunCunJingDian(datasBeans);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //展示云村经典
    private void showYunCunJingDian(final List<DataBean> datasBeans) {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        find_recyclerView_yuncunjingxuan.setLayoutManager(layoutManager);


        // recyclerView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));

        FindYCJXRecyclerviewAdapter adapter = new FindYCJXRecyclerviewAdapter(getContext(), datasBeans);
        find_recyclerView_yuncunjingxuan.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new FindYCJXRecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {

//
                Intent intent = new Intent(getContext(), VillageOfSelectedActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",datasBeans.get(position).getId());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }


    private void jiazai() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/banner?type=2");
                    Log.e(">>>>>>>>>>>>>>>>", "" + json);
                    BannersApi bannersApi = JSON.parseObject(json, BannersApi.class);
                    viewpager.post(new Runnable() {
                        @Override
                        public void run() {
                            if (bannersApi != null) {
                                showRequest(bannersApi);
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showRequest(BannersApi bannersApi) {
        titles = new String[9];
        titles[0] = bannersApi.getBanners().get(0).getTypeTitle();
        titles[1] = bannersApi.getBanners().get(1).getTypeTitle();
        titles[2] = bannersApi.getBanners().get(2).getTypeTitle();
        titles[3] = bannersApi.getBanners().get(3).getTypeTitle();
        titles[4] = bannersApi.getBanners().get(4).getTypeTitle();
        titles[5] = bannersApi.getBanners().get(5).getTypeTitle();
        titles[6] = bannersApi.getBanners().get(6).getTypeTitle();
        titles[7] = bannersApi.getBanners().get(7).getTypeTitle();
        titles[8] = bannersApi.getBanners().get(8).getTypeTitle();
        for (String str : titles) {
            Log.e("str：", str);
        }

        urls = new String[9];
        urls[0] = "http://p1.music.126.net/7m1I7vN1I2GG8CfdSuuOGg==/109951164541812713.jpg";
        urls[1] = "http://p1.music.126.net/txHzpAz0olg66HUui63SYg==/109951164540646877.jpg";
        urls[2] = "http://p1.music.126.net/3P_GTY-NoT3aMbK5lojH5Q==/109951164539469611.jpg";
        urls[3] = "http://p1.music.126.net/Bim8lgeR1zIrlN3E6ch0rg==/109951164539479095.jpg";
        urls[4] = "http://p1.music.126.net/J3dne91V0qT83Nb7Cyh-Og==/109951164540565706.jpg";
        urls[5] = "http://p1.music.126.net/4u7_5blIAOX_Y-pDFupGlA==/109951164541270379.jpg";
        urls[6] = "http://p1.music.126.net/8dWnTFGyrWODvRDdJ1ocyg==/109951164541034056.jpg";
        urls[7] = "http://p1.music.126.net/TB-Glz3N4HB7f2Hm7jGqUQ==/109951164539493809.jpg";
        urls[8] = "http://p1.music.126.net/RUuYaG2tgN2rluLYqm1j8w==/109951164539521533.jpg";
        adViewpagerUtil = new AdViewpagerUtil(getContext(), viewpager, lydots, 8, 4, urls);
        adViewpagerUtil.initVps();
        if (bannersApi.getBanners().get(0).getTitleColor().equals("red")) {
            bannerText.setBackgroundResource(R.drawable.yuanjiao);
        }

        bannerText.setText(titles[0]);


        adViewpagerUtil.setOnAdItemClickListener(new AdViewpagerUtil.OnAdItemClickListener() {
            @Override
            public void onItemClick(View v, int flag) {

                Toast.makeText(getContext(), "flag:" + flag, Toast.LENGTH_SHORT).show();
            }
        });
        adViewpagerUtil.setOnAdPageChangeListener(new AdViewpagerUtil.OnAdPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {


            }

            @Override
            public void onPageSelected(int arg0) {

                if (arg0 == 0)
                    arg0 = 1;
                if (arg0 == urls.length + 1) {
                    arg0 = urls.length;
                }
                if (bannersApi.getBanners().get(arg0 - 1).getTitleColor().equals("blue")) {
                    bannerText.setBackgroundResource(R.drawable.yuanjiao2);
                } else {
                    bannerText.setBackgroundResource(R.drawable.yuanjiao);
                }
                bannerText.setText(titles[arg0 - 1]);
                Log.e(">>>>>>>>>>>", "" + arg0);
            }
        });

    }

    @Override
    public void onRefresh() {
        stagger();
        stagger2();
        stagger3();
        stagger4();
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        }, 1000);
        Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tx_find_xindie) {
            stagger2();
            float selectedSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics());
            textView1.setTextSize(TypedValue.COMPLEX_UNIT_SP, selectedSize);
            textView1.setTextColor(getResources().getColor(R.color.selectCheck2));

            float selectedSiz2 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 14, getResources().getDisplayMetrics());
            textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, selectedSiz2);
            textView2.setTextColor(getResources().getColor(R.color.selectCheck));
            Toast.makeText(getContext(), "点击了新碟", Toast.LENGTH_LONG).show();
            btn_find_xin.setText("更多新碟");
        }
        if (view.getId() == R.id.tx_find_xinge) {
            stagger3();
            float selectedSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics());
            textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, selectedSize);
            textView2.setTextColor(getResources().getColor(R.color.selectCheck2));

            float selectedSiz2 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 14, getResources().getDisplayMetrics());
            textView1.setTextSize(TypedValue.COMPLEX_UNIT_SP, selectedSiz2);
            textView1.setTextColor(getResources().getColor(R.color.selectCheck));
            Toast.makeText(getContext(), "点击了新歌", Toast.LENGTH_LONG).show();
            btn_find_xin.setText("新歌推荐");

        }

    }
}
