package com.example.wyyproject.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import com.alibaba.fastjson.JSON;
import com.example.wyyproject.util.HttpUtil;


public class MusicService extends Service {

    private MediaPlayer mediaPlayer = new MediaPlayer();

    public MusicService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MusicServiceBinder();
    }

    public void rev() {
        if (mediaPlayer != null) {
            int position = mediaPlayer.getCurrentPosition();
            if (position > 5000) {
                position -= 5000;
            } else {
                position = 0;
            }
            mediaPlayer.seekTo(position);
        }
    }

    public void play(String songID) {
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);// 设置媒体流类型
        HttpUtil.sendGetRequest("http://tingapi.ting.baidu" +
                        ".com/v1/restserver/ting?method=baidu" +
                        ".ting.song.play&songid=" + songID,
                new HttpUtil.HttpCallbackListener() {
                    @Override
                    public void onFinish(String response) {
                        String url = JSON.parseObject(response).getJSONObject(
                                "bitrate").getString("show_link");
                        try {
                            mediaPlayer.reset();
                            mediaPlayer.setDataSource(url); //
                            // 设置数据源
                            mediaPlayer.prepare(); // prepare自动播放
                            mediaPlayer.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    public void ffw() {
        if (mediaPlayer != null) {
            int position = mediaPlayer.getCurrentPosition();
            mediaPlayer.seekTo(position + 5000);
        }
    }

    public void reload(String songID) {
        play(songID);
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public void restart() {
        mediaPlayer.start();
    }

    public class MusicServiceBinder extends Binder {
        /**
         * 获取当前Service的实例
         *
         * @return
         */
        public MusicService getService() {
            return MusicService.this;
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        mediaPlayer.release();
        return super.onUnbind(intent);
    }
}
