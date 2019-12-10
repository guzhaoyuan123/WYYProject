package com.example.wyyproject.fragment;

import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.url.banner.BannersApi;
import com.example.url.banner.BannersBean;
import com.example.wyyproject.R;
import com.example.wyyproject.util.GlideImageLoader;
import com.example.wyyproject.util.Http;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FindFragment extends Fragment {
    private Banner banner;
    private TextView bannerText;

    List<String> images = new ArrayList<>();   //定义图片集合


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
        banner =view.findViewById(R.id.banner);
        bannerText = view.findViewById(R.id.banner_text);

        initView();
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initView() {

        images.add("http://p1.music.126.net/J3dne91V0qT83Nb7Cyh-Og==/109951164540565706.jpg");
        images.add("http://p7.qhimg.com/bdm/480_296_0/t0196345b5171788e63.jpg");
        images.add("http://p7.qhimg.com/bdm/480_296_0/t017d8a373059904a5f.jpg");  //图片路径
        images.add("http://p4.qhimg.com/bdm/480_296_0/t01b45196cd0968bc6c.jpg");
        images.add("http://p8.qhimg.com/bdm/960_593_0/t01d66b4b4224232d8f.jpg");
        images.add("http://p5.qhimg.com/bdm/480_296_0/t01ae215b5ab138cc49.png");
        images.add("http://p15.qhimg.com/bdm/480_296_0/t018965ced78e0c9eec.jpg");
        images.add("http://p0.qhimg.com/bdm/480_296_0/t01d16faf458e66c0d0.jpg");
        images.add("http://p6.qhimg.com/bdm/960_593_0/t0166e7fbf01ff82ec6.jpg");

        banner.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 20);
            }
        });
        banner.setClipToOutline(true);

        stagger();
        bannerText.setText("");

        banner.setImageLoader(new GlideImageLoader());   //设置图片加载器
        banner.setImages(images);  //设置banner中显示图片
        banner.setDelayTime(4000);
        banner.start();  //设置完毕后调用
    }


    private void stagger() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("https://localhost:3000/banner?type=2");
                    BannersApi bannersApi = JSON.parseObject(json,BannersApi.class);
                    List<BannersBean> banners = bannersApi.getBanners();
                    bannerText.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(4000);
                                for (BannersBean bannersBean :banners)
                                {
                                    bannerText.setText(bannersBean.getTypeTitle());
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
