package com.example.numerosver10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.IpSecManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class PantallaFinal extends AppCompatActivity {
    Handler handler=  new Handler();
    MediaPlayer mPlayer = new MediaPlayer();
    boolean cambiar=true;
    int length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);

        mPlayer = MediaPlayer.create(this, R.raw.gameover);

        mPlayer.start();
        mPlayer.setLooping(true);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mPlayer.release();
            }
        });
    ejecutar();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPlayer.pause();
        length=mPlayer.getCurrentPosition();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPlayer.seekTo(length);
        mPlayer.start();
    }

    private void ejecutar(){
        Runnable myRunnable = new Runnable() {
            public void run() {
                volverInicio();
            }
        };
        handler.postDelayed(myRunnable,16000);
    }

    private void volverInicio(){
       /* if (cambiar){cambiar=false;}
        else{

            Intent next = new Intent(this, MainActivity.class);
            startActivity(next);
            finish();
        }*/
        mPlayer.pause();
        Intent next = new Intent(this, MainActivity.class);
        startActivity(next);
        finish();
    }
}