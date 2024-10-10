package com.example.project_unidad5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sumas extends AppCompatActivity {
    TextView tvNum1, tvNum2,tvsuma,tvigual,tvresult,tvAciertos;
    Button resp1,resp2,resp3;
    int num1, num2,resultado,numEx;
    int respCorrec = 0;
    MediaPlayer mediaPlayer, mediaPlayer1,mediaPlayer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumas);

        tvNum1 = findViewById(R.id.tvNum1);
        tvNum2 = findViewById(R.id.tvNum2);
        tvsuma = findViewById(R.id.tvsuma);
        tvresult = findViewById(R.id.tvresult);
        tvigual = findViewById(R.id.tvigual);
        resp1 = findViewById(R.id.resp1);
        resp2 = findViewById(R.id.resp2);
        resp3 = findViewById(R.id.resp3);
        tvAciertos = findViewById(R.id.tvAciertos);
        generarPregunta(resp1,resp2,resp3);
        mediaPlayer = MediaPlayer.create(this,R.raw.duolingo_correct);
        mediaPlayer1 = MediaPlayer.create(this,R.raw.duolingo_wrong);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.complete);
        tvAciertos.setText("Aciertos: "+respCorrec);
        }

        public void verificarRespuesta(int respSele, int resultado){
                if(respSele == resultado){
                    Toast toast = (Toast) FancyToast.makeText(this,"¡CORRECTO!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

                    respCorrec += 1;
                    tvAciertos.setText("Aciertos: "+respCorrec);
                    if(mediaPlayer != null)
                        mediaPlayer.start();
                    if(respCorrec < 10){
                        generarPregunta(resp1,resp2,resp3);
                    }else{
                        FancyToast.makeText(this,"Has completado este nivel!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                        Intent intent = new Intent(getApplicationContext(),DificultadSumas.class);
                        startActivity(intent);
                        mediaPlayer2.start();
                    }
                }else{
                    if(mediaPlayer1 != null)
                        mediaPlayer1.start();
                    return;
                }
        }

        public void generarPregunta(Button b1, Button b2, Button b3) {
            Random random = new Random();
            num1 = random.nextInt(10) + 1;
            num2 = random.nextInt(10) + 1;
            resultado = num1 + num2;
            numEx = random.nextInt(5) + 1;

            List<Integer> respuestas = Arrays.asList(resultado, resultado + numEx, resultado - 1);
            Collections.shuffle(respuestas);

            tvNum1.setText(String.valueOf(num1));
            tvNum2.setText(String.valueOf(num2));
            resp1.setText(String.valueOf(respuestas.get(0)));
            resp2.setText(String.valueOf(respuestas.get(1)));
            resp3.setText(String.valueOf(respuestas.get(2)));

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    verificarRespuesta(Integer.parseInt(b1.getText().toString()),resultado);
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    verificarRespuesta(Integer.parseInt(b2.getText().toString()),resultado);
                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    verificarRespuesta(Integer.parseInt(b3.getText().toString()),resultado);
                }
            });
        }
}