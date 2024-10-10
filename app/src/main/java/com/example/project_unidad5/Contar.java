package com.example.project_unidad5;

import androidx.annotation.DrawableRes;
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

public class Contar extends AppCompatActivity {

    Button resp1,resp2,resp3;
    TextView tvAciertos;
    ImageView imageView;
    int numero;
    int respCorrec = 0;
    MediaPlayer mediaPlayer,mediaPlayer1,mediaPlayer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contar);

        resp1 = findViewById(R.id.resp1);
        resp2 = findViewById(R.id.resp2);
        resp3 = findViewById(R.id.resp3);
        imageView = findViewById(R.id.imageView);
        tvAciertos = findViewById(R.id.tvAciertos);

        mediaPlayer = MediaPlayer.create(this,R.raw.duolingo_correct);
        mediaPlayer1 = MediaPlayer.create(this,R.raw.duolingo_wrong);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.complete);
        tvAciertos.setText("Aciertos: "+respCorrec);
        generador(resp1,resp2,resp3);

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
            if(respCorrec < 10){
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
                imageView.setBackgroundResource(R.drawable.cangrejo);
                break;
            case 2:
                imageView.setBackgroundResource(R.drawable.i2);
                break;
            case 3:
                imageView.setBackgroundResource(R.drawable.i3);
                break;
            case 4:
                imageView.setBackgroundResource(R.drawable.i4);
                break;
            case 5:
                imageView.setBackgroundResource(R.drawable.i5);
                break;
            case 6:
                imageView.setBackgroundResource(R.drawable.i6);
                break;
            case 7:
                imageView.setBackgroundResource(R.drawable.i7);
                break;
            case 8:
                imageView.setBackgroundResource(R.drawable.i8);
                break;
            case 9:
                imageView.setBackgroundResource(R.drawable.i9);
                break;
            case 10:
                imageView.setBackgroundResource(R.drawable.i10);
                break;
        }

        List<Integer> respuestas = Arrays.asList(numero, numero + 1, numero - 1);
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
}