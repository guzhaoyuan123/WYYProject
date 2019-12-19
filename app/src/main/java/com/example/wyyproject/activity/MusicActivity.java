package com.example.wyyproject.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.url.music.DataBean;
import com.example.url.music.Music;
import com.example.wyyproject.R;
import com.example.wyyproject.util.Http;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {

    //定义各类控件
    private ImageView backIv;
    private ImageView nextIv;
    private RoundedImageView discsmap;
    private ImageView pauseIv;
    private MediaPlayer mediaPlayer;
    private ObjectAnimator animator;
    private TextView currentTv;
    private TextView totalTv;
    private int totalTime;
    private SeekBar jindutiaoSb;
    private boolean isStop;
    //接受多线程信息，安卓中不允许主线程实现UI更新
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            float c = msg.what;
            jindutiaoSb.setProgress((int)(c/totalTime*100));
            currentTv.setText(formatTime(msg.what));

        }
    };



//     //加载背景，
//            Glide.with(MusicPlayerActivity.this)
//                    .load(service.getImageUri())
//                    .dontAnimate()
//                    .error(R.drawable.no_music_rotate_img)
//                    // 设置高斯模糊
//                    .bitmapTransform(new BlurTransformation(this, 14, 3))
//                    .into(allBg);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        Intent intent = getIntent();
        String id=intent.getStringExtra("musicId");
        String name=intent.getStringExtra("musicName");
        String zuozhe=intent.getStringExtra("musicZuozhe");
        String picture=intent.getStringExtra("musicPicture");


        Link();//绑定ID方法
        initView(id);
            Glide.with(this)
                    .load(picture)
                    // 25：模糊半径，越大图片越模糊 范围：1-25，1：缩放倍数
//                    .bitmapTransform(new BlurTransformation(this, 25,1))
//                    .bitmapTransform(new BlurTransformation(this, 14, 3))
                    .into(discsmap);




//获取传值
//获取mediaplayer
        mediaPlayer = new MediaPlayer();




/////////////////////////获取进度条点击位置并使歌曲跳转到该位置////////////////////////////////////
        jindutiaoSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initView(String id) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/song/url?id="+id+"");
                    Log.e("????????????", "" + json);
                    Music music = JSON.parseObject(json, Music.class);
                    List<DataBean> datasBeans = music.getData();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            play(datasBeans.get(0).getUrl(),datasBeans.get(0).getSize());//歌曲播放及一系列操作方法
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



    private void play(String path,int length) {

        mediaPlayer.reset();

        /////////////////////歌曲播放////////////////////////////////////////////////////
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

        backIv.setOnClickListener(this);
        nextIv.setOnClickListener(this);
        pauseIv.setOnClickListener(this);

        ///////////////////////////////////唱片打碟/////////////////////////////////////////////
        animator = ObjectAnimator.ofFloat(discsmap, "rotation", 0f, 360.0f);
        animator.setDuration(10000);
        animator.setInterpolator(new LinearInterpolator());//匀速
        animator.setRepeatCount(-1);//设置动画重复次数（-1代表一直转）
        animator.setRepeatMode(ValueAnimator.RESTART);//动画重复模式
        animator.start();

        ////////////////////////////////进度条/////////////////////////////////////////////////

        totalTv.setText(formatTime(length));
        totalTime = length;
        new Thread(new SeekBarThread()).start();
        jindutiaoSb.setMax(length);

        ////////////////////////////指针拨动////////////////////////////////////////////////////
//        animator1 = ObjectAnimator.ofFloat(zhizhenmap, "rotation", -60f, 0.0f);
//        animator1.setDuration(900);
//        animator1.setRepeatCount(0);//设置动画重复次数（-1代表一直转）
//        animator1.start();
    }

    ///////////////获取歌曲时常///////////////////////
    private String formatTime(int length) {
        Date date = new Date(length);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        String TotalTime = simpleDateFormat.format(date);

        return TotalTime;

    }

    private void Link() {

        backIv = findViewById(R.id.listen_back_img);
        nextIv = findViewById(R.id.listen_next_img);
        discsmap = findViewById(R.id.round_music_changpian);
        pauseIv = findViewById(R.id.listen_pause1_img);
        currentTv = findViewById(R.id.listen_current_tv);
        totalTv = findViewById(R.id.listen_length_tv);
        jindutiaoSb = findViewById(R.id.listen_jindutiao_sb);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.listen_back_img:
//                position--;
//                if (position == -1) {
//                    position = Common.musicList.size() - 1;
//                }
//                play("",10);
                break;
            case R.id.listen_next_img:
//                position++;
//                if (position == Common.musicList.size()) {
//                    position = 0;
//                }
//                play();
            case R.id.listen_pause1_img:

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    animator.pause();
                    pauseIv.setImageResource(R.mipmap.wxr2);
                } else {
                    mediaPlayer.start();
                    pauseIv.setImageResource(R.mipmap.starplay);
                    animator.resume();
//                    animator1.resume();

                }
            default:
                break;


        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.reset();
        isStop = true;
    }

    class SeekBarThread implements Runnable {

        @Override
        public void run() {
            while (mediaPlayer != null && isStop == false) {
                // 将SeekBar位置设置到当前播放位置
                handler.sendEmptyMessage(mediaPlayer.getCurrentPosition());
                try {
                    // 每100毫秒更新一次位置
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
