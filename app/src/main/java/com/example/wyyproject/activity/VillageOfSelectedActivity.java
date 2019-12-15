package com.example.wyyproject.activity;

import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.alibaba.fastjson.JSON;
import com.example.url.yuncunjingxuanshiping.BrsBean;
import com.example.url.yuncunjingxuanshiping.YunCunJingXuanSHiPing;
import com.example.wyyproject.R;
import com.example.wyyproject.util.Http;

import java.io.IOException;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class VillageOfSelectedActivity extends AppCompatActivity {

    private VideoView videoView;
    private Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setEnterTransition(new Slide().setDuration(2000));
        getWindow().setExitTransition(new Slide().setDuration(2000));
        setContentView(R.layout.activity_village_of_selected);

        // 设置标题栏回退按钮，及点击事件
        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VillageOfSelectedActivity.this.finish();
            }
        });

        videoView = findViewById(R.id.player_list_video);
        videoView.setZOrderOnTop(true);
        videoView.setBackgroundResource(R.mipmap.xiaobeijing1);
        videoView.setVideoPath("https://htmlpicture.oss-cn-beijing.aliyuncs.com/baidong.mp4");
        //创建MediaController对象
        MediaController mediaController = new MediaController(VillageOfSelectedActivity.this);
        //VideoView与MediaController建立关联
        videoView.setMediaController(mediaController);
        //让VideoView获取焦点
        videoView.requestFocus();
    }

    //加载云村经典
    private void stagger4(int id) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/mv/detail?mvid="+id+"");
                    YunCunJingXuanSHiPing yunCunJingXuanSHiPing = JSON.parseObject(json, YunCunJingXuanSHiPing.class);
                    com.example.url.yuncunjingxuanshiping.DataBean data = yunCunJingXuanSHiPing.getData();
                    BrsBean brsBean = data.getBrs();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            videoView = findViewById(R.id.player_list_video);
                            videoView.setZOrderOnTop(true);
                            String path = brsBean.get_$240();
                            videoView.setVideoPath("http://vodkgeyttp8.vod.126.net/cloudmusic/MjQ3NDQ3MjUw/89a6a279dc2acfcd068b45ce72b1f560/bf2750483ed02d4c6263dffefa5959d7.mp4?wsSecret=bbeb74cc95b97d0dbb64257f7a8ea8b3&wsTime=1576153499");
                            //创建MediaController对象
                            MediaController mediaController = new MediaController(VillageOfSelectedActivity.this);
                            //VideoView与MediaController建立关联
                            videoView.setMediaController(mediaController);
                            //让VideoView获取焦点
                            videoView.requestFocus();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
