package com.example.project_unidad5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Compite extends AppCompatActivity {
    Button resp1,resp2,resp3,resp1p2,resp2p2,resp3p2;
    TextView tvAciertos,tvAciertosp2;
    ImageView imap1,imap;
    int numero,numero2;
    int respCorrec = 0;
    int respCorrecp2 = 0;
    MediaPlayer mediaPlayer,mediaPlayer1,mediaPlayer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compite);

        resp1 = findViewById(R.id.resp1);
        resp2 = findViewById(R.id.resp2);
        resp3 = findViewById(R.id.resp3);
        resp1p2 = findViewById(R.id.resp1p2);
        resp2p2 = findViewById(R.id.resp2p2);
        resp3p2 = findViewById(R.id.resp3p2);
        imap = findViewById(R.id.imap);
        imap1 = findViewById(R.id.imap1);
        tvAciertos = findViewById(R.id.tvAciertos);
        tvAciertosp2 = findViewById(R.id.tvAciertosp2);

        mediaPlayer = MediaPlayer.create(this,R.raw.duolingo_correct);
        mediaPlayer1 = MediaPlayer.create(this,R.raw.duolingo_wrong);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.complete);
        generador(resp1,resp2,resp3);
        generadorp2(resp1p2,resp2p2,resp3p2);
        tvAciertos.setText("Aciertos: "+respCorrec);
        tvAciertosp2.setText("Aciertos: "+respCorrecp2);
    }

    public void verificarRespuesta(int numSele, int num){

        if(numSele == num){
            Toast toast = (Toast) FancyToast.makeText(this,"¡CORRECTO!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            respCorrec += 1;
            tvAciertos.setText("Aciertos: "+respCorrec);
            if(mediaPlayer != null)
                mediaPlayer.start();
            if(respCorrec < 100){
                generador(resp1,resp2,resp3);
            }else{
                mediaPlayer2.start();
                FancyToast.makeText(this,"Has completado este nivel!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }else{
            if(mediaPlayer1 != null)
                mediaPlayer1.start();
        }
    }
    public void generador(Button b1, Button b2, Button b3) {
        Random random = new Random();
        numero = random.nextInt(10)+1;

        switch(numero){
            case 1:
                imap1.setBackgroundResource(R.drawable.cangrejo);
                break;
            case 2:
                imap1.setBackgroundResource(R.drawable.i2);
                break;
            case 3:
                imap1.setBackgroundResource(R.drawable.i3);
                break;
            case 4:
                imap1.setBackgroundResource(R.drawable.i4);
                break;
            case 5:
                imap1.setBackgroundResource(R.drawable.i5);
                break;
            case 6:
                imap1.setBackgroundResource(R.drawable.i6);
                break;
            case 7:
                imap1.setBackgroundResource(R.drawable.i7);
                break;
            case 8:
                imap1.setBackgroundResource(R.drawable.i8);
                break;
            case 9:
                imap1.setBackgroundResource(R.drawable.i9);
                break;
            case 10:
                imap1.setBackgroundResource(R.drawable.i10);
                break;
        }

        List<Integer> respuestas= Arrays.asList(numero, numero + 1, numero - 1);
        Collections.shuffle(respuestas);

        resp1.setText(String.valueOf(respuestas.get(0)));
        resp2.setText(String.valueOf(respuestas.get(1)));
        resp3.setText(String.valueOf(respuestas.get(2)));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuesta(Integer.parseInt(b1.getText().toString()),numero);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuesta(Integer.parseInt(b2.getText().toString()),numero);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuesta(Integer.parseInt(b3.getText().toString()),numero);
            }
        });
    }

    public void verificarRespuestap2(int numSele2, int num2){

        if(numSele2 == num2){
            Toast toast = (Toast) FancyToast.makeText(this,"¡CORRECTO!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            respCorrecp2 += 1;
            tvAciertosp2.setText("Aciertos: "+respCorrecp2);
            if(mediaPlayer != null)
                mediaPlayer.start();
            if(respCorrec < 100){
                generadorp2(resp1p2,resp2p2,resp3p2);
            }else{
                mediaPlayer2.start();
                FancyToast.makeText(this,"Has completado este nivel!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }else{
            if(mediaPlayer1 != null)
                mediaPlayer1.start();
        }
    }
    public void generadorp2(Button b4, Button b5, Button b6) {
        Random random2 = new Random();
        numero2 = random2.nextInt(10)+1;

        switch(numero2){
            case 1:
                imap.setBackgroundResource(R.drawable.cangrejo);
                break;
            case 2:
                imap.setBackgroundResource(R.drawable.i2);
                break;
            case 3:
                imap.setBackgroundResource(R.drawable.i3);
                break;
            case 4:
                imap.setBackgroundResource(R.drawable.i4);
                break;
            case 5:
                imap.setBackgroundResource(R.drawable.i5);
                break;
            case 6:
                imap.setBackgroundResource(R.drawable.i6);
                break;
            case 7:
                imap.setBackgroundResource(R.drawable.i7);
                break;
            case 8:
                imap.setBackgroundResource(R.drawable.i8);
                break;
            case 9:
                imap.setBackgroundResource(R.drawable.i9);
                break;
            case 10:
                imap.setBackgroundResource(R.drawable.i10);
                break;
        }

        List<Integer> respuestasp2 = Arrays.asList(numero2, numero2 + 1, numero2 - 1);
        Collections.shuffle(respuestasp2);

        resp1p2.setText(String.valueOf(respuestasp2.get(0)));
        resp2p2.setText(String.valueOf(respuestasp2.get(1)));
        resp3p2.setText(String.valueOf(respuestasp2.get(2)));

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuestap2(Integer.parseInt(b4.getText().toString()),numero2);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuestap2(Integer.parseInt(b5.getText().toString()),numero2);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuestap2(Integer.parseInt(b6.getText().toString()),numero2);
            }
        });
    }
}

