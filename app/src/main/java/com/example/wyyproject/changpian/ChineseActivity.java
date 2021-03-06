package com.example.wyyproject.changpian;

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
import com.example.wyyproject.util.ChineseCommon;
import com.example.wyyproject.util.Http;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class ChineseActivity extends AppCompatActivity implements View.OnClickListener {

    //定义各类控件
    private ImageView backIv;
    private ImageView nextIv;
    private RoundedImageView discsmap;
    private ImageView pauseIv;
    private MediaPlayer mediaPlayer;
    private ObjectAnimator animator;
    private TextView currentTv;
    private TextView totalTv;
    private ImageView imgMusicFanhui,imgMusicFenXiang;
    private TextView imgMusicGeMinga;
    private TextView imgMusicZuoZhe;
    private int position;
    private SeekBar jindutiaoSb;
    private boolean isStop;
    //接受多线程信息，安卓中不允许主线程实现UI更新
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            jindutiaoSb.setProgress(msg.what);
            currentTv.setText(formatTime(msg.what));
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        Intent intent = getIntent();
        position=intent.getIntExtra("postion",0);



        Link();
        initView(position);
//
//        Glide.with(this).load(picture).into(discsmap);
        mediaPlayer = new MediaPlayer();


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

    private void initView(int position) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/song/url?id=" + ChineseCommon.musicList.get(position).getId() + "");
                    Log.e("????????????", "" + json);
                    Music music = JSON.parseObject(json, Music.class);
                    List<DataBean> datasBeans = music.getData();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (datasBeans.get(0).getUrl() ==null){
                                initView(position-1);
                            }else {
                                play(datasBeans.get(0).getUrl(), datasBeans.get(0).getSize(),position);
                            }

                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void play(String path, long length,int position) {
        imgMusicGeMinga.setText(ChineseCommon.musicList.get(position).getName());
        imgMusicZuoZhe.setText(ChineseCommon.musicList.get(position).getAr().get(0).getName());
        Glide.with(this).load(ChineseCommon.musicList.get(position).getAl().getPicUrl()).into(discsmap);

        backIv.setOnClickListener(this);
        nextIv.setOnClickListener(this);
        pauseIv.setOnClickListener(this);
        imgMusicFenXiang.setOnClickListener(this);
        imgMusicFanhui.setOnClickListener(this);
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        animator = ObjectAnimator.ofFloat(discsmap, "rotation", 0f, 360.0f);
        animator.setDuration(10000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(-1);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.start();

        totalTv.setText(formatTime(length));
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mediaPlayer != null && isStop == false) {
                    handler.sendEmptyMessage(mediaPlayer.getCurrentPosition());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        jindutiaoSb.setMax((int) length);
    }
    private String formatTime(long length) {
        Date date = new Date(length);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("m:ss");
        String TotalTime = simpleDateFormat.format(date);
        return TotalTime;
    }

    private void Link() {
        imgMusicFanhui=findViewById(R.id.img_music_fanhui);
        imgMusicFenXiang=findViewById(R.id.img_music_fenxiang);
        imgMusicGeMinga=findViewById(R.id.tx_music_geming);
        imgMusicZuoZhe=findViewById(R.id.tx_music_zuozhe);
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
            case R.id.img_music_fanhui:
                ChineseActivity.this.finish();
                break;
            case R.id.listen_back_img:
                position--;
                if (position == -1) {
                    position = ChineseCommon.musicList.size()-1;
                }
                initView(position);
                pauseIv.setImageResource(R.mipmap.starplay);
                break;
            case R.id.listen_next_img:
                position++;
                if (position == ChineseCommon.musicList.size()) {
                    position = 0;
                }
                initView(position);
                pauseIv.setImageResource(R.mipmap.starplay);
            case R.id.listen_pause1_img:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    animator.pause();
                    pauseIv.setImageResource(R.mipmap.starplay);
                } else {
                    mediaPlayer.start();
                    pauseIv.setImageResource(R.mipmap.stopplay);
                    animator.resume();
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

}
