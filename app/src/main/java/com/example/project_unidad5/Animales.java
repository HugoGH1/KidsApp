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

public class Animales extends AppCompatActivity {
    Button resp1, resp2, resp3;
    TextView tvAciertos;
    ImageView animal;
    MediaPlayer mediaPlayer, mediaPlayer1, mediaPlayer2;
    char letraCorr, letraS2, letraS3;
    int respCorrec = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales);

        resp1 = findViewById(R.id.resp1);
        resp2 = findViewById(R.id.resp2);
        resp3 = findViewById(R.id.resp3);
        tvAciertos = findViewById(R.id.tvAciertos);
        animal = findViewById(R.id.animal);

        generarPregunta(resp1, resp2, resp3);
        crearAudios();
    }

    public void verificarRespuesta(String respSele, char correcto) {
        if (respSele.equals(String.valueOf(correcto))) {
            Toast toast = (Toast) FancyToast.makeText(this, "¡CORRECTO!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            respCorrec += 1;
            tvAciertos.setText("Aciertos: " + respCorrec);
            if (mediaPlayer != null)
                mediaPlayer.start();
            if (respCorrec < 15) {
                generarPregunta(resp1, resp2, resp3);
            } else {
                FancyToast.makeText(this, "Lo hiciste muy bien!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                mediaPlayer2.start();
            }
        } else {
            if (mediaPlayer1 != null)
                mediaPlayer1.start();
        }
    }

    public void generarPregunta(Button b1, Button b2, Button b3) {
        Random random = new Random();
        letraCorr = (char) (random.nextInt('Z' - 'A' + 1) + 'A');
        letraS2 = (char) (random.nextInt('Z' - 'A' + 1) + 'A');
        letraS3 = (char) (random.nextInt('Z' - 'A' + 1) + 'A');

        PonerInicial(letraCorr);

        if (letraCorr == letraS2 || letraCorr == letraS3 || letraS2 == letraS3) {
            generarPregunta(resp1, resp2, resp3);
        } else {
            List<Character> respuestas = Arrays.asList(letraCorr, letraS2, letraS3);
            Collections.shuffle(respuestas);

            resp1.setText(String.valueOf(respuestas.get(0)));
            resp2.setText(String.valueOf(respuestas.get(1)));
            resp3.setText(String.valueOf(respuestas.get(2)));

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    verificarRespuesta(b1.getText().toString(), letraCorr);
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    verificarRespuesta(b2.getText().toString(), letraCorr);
                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    verificarRespuesta(b3.getText().toString(), letraCorr);
                }
            });
        }

    }

    public void PonerInicial(char animalC) {
        switch (animalC) {
            case 'A':
                animal.setBackgroundResource(R.drawable.a);
                break;
            case 'B':
                animal.setBackgroundResource(R.drawable.b);
                break;
            case 'C':
                animal.setBackgroundResource(R.drawable.c);
                break;
            case 'D':
                animal.setBackgroundResource(R.drawable.d);
                break;
            case 'E':
                animal.setBackgroundResource(R.drawable.e);
                break;
            case 'F':
                animal.setBackgroundResource(R.drawable.f);
                break;
            case 'G':
                animal.setBackgroundResource(R.drawable.g);
                break;
            case 'H':
                animal.setBackgroundResource(R.drawable.h);
                break;
            case 'I':
                animal.setBackgroundResource(R.drawable.i);
                break;
            case 'J':
                animal.setBackgroundResource(R.drawable.j);
                break;
            case 'K':
                animal.setBackgroundResource(R.drawable.k);
                break;
            case 'L':
                animal.setBackgroundResource(R.drawable.l);
                break;
            case 'M':
                animal.setBackgroundResource(R.drawable.m);
                break;
            case 'N':
                animal.setBackgroundResource(R.drawable.n);
                break;
            //case 'Ñ':
               // animal.setBackgroundResource(R.drawable.pro);
               // break;
            case 'O':
                animal.setBackgroundResource(R.drawable.o);
                break;
            case 'P':
                animal.setBackgroundResource(R.drawable.p);
                break;
            case 'Q':
                animal.setBackgroundResource(R.drawable.q);
                break;
            case 'R':
                animal.setBackgroundResource(R.drawable.r);
                break;
            case 'S':
                animal.setBackgroundResource(R.drawable.s);
                break;
            case 'T':
                animal.setBackgroundResource(R.drawable.t);
                break;
            case 'U':
                animal.setBackgroundResource(R.drawable.u);
                break;
            case 'V':
                animal.setBackgroundResource(R.drawable.v);
                break;
            case 'W':
                animal.setBackgroundResource(R.drawable.w);
                break;
            case 'X':
                animal.setBackgroundResource(R.drawable.x);
                break;
            case 'Y':
                animal.setBackgroundResource(R.drawable.y);
                break;
            case 'Z':
                animal.setBackgroundResource(R.drawable.z);
                break;


        }

    }

    public void crearAudios(){
        mediaPlayer = MediaPlayer.create(this, R.raw.duolingo_correct);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.duolingo_wrong);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.complete);

    }
}
