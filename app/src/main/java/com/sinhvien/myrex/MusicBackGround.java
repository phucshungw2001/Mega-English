package com.sinhvien.myrex;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public abstract class MusicBackGround extends Service {

    private MediaPlayer backgroundMusic;

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public void onCreate() {
        backgroundMusic = MediaPlayer.create(getApplicationContext(),R.raw.background_music);
        backgroundMusic.setLooping(true);
    }

    @Override
    public void onStart(Intent intent, int startId) {
       backgroundMusic.start();
    }

    @Override
    public void onDestroy() {
        backgroundMusic.stop();
    }
}
