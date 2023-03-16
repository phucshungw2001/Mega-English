package com.sinhvien.myrex;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class listen_activity extends AppCompatActivity {

    private TextView txtTitle,txtTimeSong,txtTimeTotal;
    private SeekBar skSong;
    private ImageView btnPrev, btnStop, btnNext;
    private ImageView btnPlay;
    private int position = 0;
    private MediaPlayer mediaPlayer;

    ArrayList<Audio_listen> arraySong;

    private void bindingView(){
        txtTitle =  findViewById(R.id.txtTitle);
        txtTimeSong =  findViewById(R.id.timeSong);
        txtTimeTotal =  findViewById(R.id.timeTotal);
        skSong =  findViewById(R.id.seekBar);
        btnPrev =  findViewById(R.id.previous);
        btnPlay =  findViewById(R.id.start);
        btnStop =  findViewById(R.id.stop);
        btnNext =  findViewById(R.id.next);
    }

    private  void  bindingAction(){
        btnPlay.setOnClickListener(this :: onBtnClickPlaye);
        btnStop.setOnClickListener(this :: onBtnClickStop);
        btnPrev.setOnClickListener(this :: onBtnClickPrev);
        btnNext.setOnClickListener(this :: onBtnClickNext);
    }

    private void onBtnClickNext(View view) {
        position --;
        if (position < 0){
            position = arraySong.size() - 1;
        }
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        KhoiTaoMediaPlayer();
        mediaPlayer.start();
        btnPlay.setImageResource(R.drawable.btnplay);
        SetTimeTotal();
        UpdateTimeSong();
    }

    private void onBtnClickPrev(View view) {
        position++;
        if (position > arraySong.size() - 1){
            position = 0;
        }
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        KhoiTaoMediaPlayer();
        mediaPlayer.start();
        btnPlay.setImageResource(R.drawable.btnplay);
        SetTimeTotal();
        UpdateTimeSong();
    }

    private void onBtnClickStop(View view) {
        mediaPlayer.stop();
        mediaPlayer.release();
        btnPlay.setImageResource(R.drawable.btnplay);
        KhoiTaoMediaPlayer();
    }

    private void onBtnClickPlaye(View view) {
        if (btnPlay.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.btnplay).getConstantState())) {
            mediaPlayer.start();
            btnPlay.setImageResource(R.drawable.btnpause);
        } else {
            mediaPlayer.pause();
            btnPlay.setImageResource(R.drawable.btnplay);
        }
        SetTimeTotal();
        UpdateTimeSong();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);
        bindingView();
        bindingAction();

        AddSong();
        KhoiTaoMediaPlayer();
        SetTimeTotal();

        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSong.getProgress());
            }
        });
    }
    private void SetTimeTotal()
    {
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        txtTimeTotal.setText(dinhDangGio.format(mediaPlayer.getDuration()));
        skSong.setMax(mediaPlayer.getDuration());
    }
    private void UpdateTimeSong()
    {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                txtTimeSong.setText(dinhDangGio.format(mediaPlayer.getCurrentPosition()));
                skSong.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this,500);
            }
        },100);
    }
    private void KhoiTaoMediaPlayer(){
        mediaPlayer = MediaPlayer.create(listen_activity.this,arraySong.get(position).getFile());
        txtTitle.setText(arraySong.get(position).getTitle());
    }

    private void AddSong()
    {
        arraySong = new ArrayList<>();
        arraySong.add(new Audio_listen("Greeting", R.raw.audio_chaohoi));
        arraySong.add(new Audio_listen("Express Emotions", R.raw.audio_vuimunghp));
        arraySong.add(new Audio_listen("Interests", R.raw.audio_sothich));
        arraySong.add(new Audio_listen("Shopping", R.raw.audio_muasam));
        arraySong.add(new Audio_listen("Movie Theater", R.raw.audio_rapphim));

    }
}