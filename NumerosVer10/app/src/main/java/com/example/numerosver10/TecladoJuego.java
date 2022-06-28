package com.example.numerosver10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numerosver10.patrones.Fachada;

public class TecladoJuego extends AppCompatActivity {
    String cadena;
    Button uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, punto, del, aceptar;
    TextView valor, problema, puntaje;
    MediaPlayer mPlayer = new MediaPlayer();
    int length;
    Fachada facade = new Fachada();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teclado_juego);

        mPlayer = MediaPlayer.create(this, R.raw.musica_fondo);

        mPlayer.start();
        mPlayer.setLooping(true);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mPlayer.release();
            }
        });


        //MediaPlayer mMediaPlayer = MediaPlayer.create(this, R.raw.musica_fondo);

        //mMediaPlayer.start();



        uno = (Button) findViewById(R.id.btn_uno);
        dos = (Button) findViewById(R.id.btn_dos);
        tres = (Button) findViewById(R.id.btn_tres);
        cuatro = (Button) findViewById(R.id.btn_cuatro);
        cinco = (Button) findViewById(R.id.btn_cinco);
        seis = (Button) findViewById(R.id.btn_seis);
        siete = (Button) findViewById(R.id.btn_siete);
        ocho = (Button) findViewById(R.id.btn_ocho);
        nueve = (Button) findViewById(R.id.btn_nueve);
        cero = (Button) findViewById(R.id.btn_cero);
        punto = (Button) findViewById(R.id.btn_punto);
        del = (Button) findViewById(R.id.btn_del);
        aceptar = (Button) findViewById(R.id.btn_enter);

        facade.juegoNuevo();

        valor = (TextView) findViewById(R.id.txt_respuesta);
        problema = (TextView) findViewById(R.id.txt_Problema);
        puntaje = (TextView) findViewById(R.id.txt_puntos);
        valor.setText("");
        problema.setText(facade.obtenerProblema());



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


    public void teclado(View view) {
        switch (view.getId()) {
            case R.id.btn_uno:
                valor.setText(valor.getText().toString() + "1");
                break;
            case R.id.btn_dos:
                valor.setText(valor.getText().toString() + "2");
                break;
            case R.id.btn_tres:
                valor.setText(valor.getText().toString() + "3");
                break;
            case R.id.btn_cuatro:
                valor.setText(valor.getText().toString() + "4");
                break;
            case R.id.btn_cinco:
                valor.setText(valor.getText().toString() + "5");
                break;
            case R.id.btn_seis:
                valor.setText(valor.getText().toString() + "6");
                break;
            case R.id.btn_siete:
                valor.setText(valor.getText().toString() + "7");
                break;
            case R.id.btn_ocho:
                valor.setText(valor.getText().toString() + "8");
                break;
            case R.id.btn_nueve:
                valor.setText(valor.getText().toString() + "9");
                break;
            case R.id.btn_cero:
                valor.setText(valor.getText().toString() + "0");
                break;
            case R.id.btn_punto:

                if(encontrarpunto()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Ya hay un punto", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                }
                else{
                valor.setText(valor.getText().toString() + ".");
                }
                break;
            case R.id.btn_del:
                cadena=valor.getText().toString();
                if (cadena.isEmpty()||cadena==""){
                    Toast toast = Toast.makeText(getApplicationContext(), "Vacio", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                }
                else{
                valor.setText(cadena.substring(0, cadena.length() - 1));
                }
                break;
            case R.id.btn_enter:
                cadena=valor.getText().toString();
                if (cadena.isEmpty()||cadena==""){
                    Toast toast = Toast.makeText(getApplicationContext(), "Vacio", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                }
                else{
                resultadoVeredicto(facade.validarRespuesta(valor.getText().toString()));
                }
                break;

        }


    }

    private boolean encontrarpunto(){
        cadena=valor.getText().toString();
        int caracter = cadena.indexOf('.');

        if (caracter==-1){
            return false;
        }
        return true;
        //Log.d("Tag", String.valueOf(caracter));
    }

    private void resultadoVeredicto(boolean veredicto){
        if (veredicto){
            facade.aumentarPunto();
            Toast toast = Toast.makeText(getApplicationContext(), "Correto", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();
        }
        else{
            facade.restarvida();
            Toast toast = Toast.makeText(getApplicationContext(), "Equivocado", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();
        }
        problema.setText(facade.obtenerProblema());
        valor.setText("");
        finJuego();
    }

    private void finJuego(){
        if(facade.obtenerVidas()<1){
            mPlayer.pause();
            Intent next = new Intent(this, PantallaFinal.class);
            startActivity(next);
            finish();
        }
        else{
            puntaje.setText("Puntos: "+facade.tenerpuntos());
        }
    }




}