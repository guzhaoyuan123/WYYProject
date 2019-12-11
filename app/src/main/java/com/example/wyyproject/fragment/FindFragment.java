package com.example.wyyproject.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.url.banner.BannersApi;
import com.example.url.banner.BannersBean;
import com.example.wyyproject.MainActivity;
import com.example.wyyproject.R;
import com.example.wyyproject.util.AdViewpagerUtil;
import com.example.wyyproject.util.Http;

import java.io.IOException;



public class FindFragment extends Fragment {
    private ViewPager viewpager;
    private RecyclerView recyclerView;
    private LinearLayout lydots;
    private static String[] urls,titles;
    private AdViewpagerUtil adViewpagerUtil;
    private TextView bannerText;

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
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_find,container,false);
        bannerText = view.findViewById(R.id.banner_text);
        viewpager = view.findViewById(R.id.viewpager);
        lydots =view.findViewById(R.id.ly_dots);

//        recyclerView=view.findViewById(R.id.find_recyclerView);
        initView();
        jiazai();
        return view;
    }

    private void initView() {


    }


    private  void  jiazai(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/banner?type=2");
                    Log.e(">>>>>>>>>>>>>>>>",""+json);
                    BannersApi bannersApi = JSON.parseObject(json,BannersApi.class);
                    viewpager.post(new Runnable() {
                        @Override
                        public void run() {
                            if (bannersApi!=null){
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
        for (String str :titles){
            Log.e("str：",str);
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
        if (bannersApi.getBanners().get(0).getTitleColor().equals("red")){
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

                if(arg0 == 0)
                    arg0 = 1;
                if(arg0 == urls.length + 1)
                {
                    arg0 = urls.length;
                }
                if (bannersApi.getBanners().get(arg0-1).getTitleColor().equals("blue")){
                    bannerText.setBackgroundResource(R.drawable.yuanjiao2);
                }else {
                    bannerText.setBackgroundResource(R.drawable.yuanjiao);
                }
                bannerText.setText(titles[arg0-1]);
                Log.e(">>>>>>>>>>>",""+arg0);
            }
        });

    }

}
