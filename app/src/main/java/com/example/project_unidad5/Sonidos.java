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

public class Sonidos extends AppCompatActivity {
    Button btnaudios, resp1, resp2, resp3;
    TextView tvAciertos;
    ImageView imageView;
    MediaPlayer a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, mediaPlayer, mediaPlayer1, mediaPlayer2;
    char letraCorr, letraS2, letraS3;
    int respCorrec = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonidos);

        btnaudios = findViewById(R.id.btnaudios);
        resp1 = findViewById(R.id.resp1);
        resp2 = findViewById(R.id.resp2);
        resp3 = findViewById(R.id.resp3);
        tvAciertos = findViewById(R.id.tvAciertos);
        imageView = findViewById(R.id.imageView3);
        imageView.setBackgroundResource(R.drawable.sonido);

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

        EscucharLetra(letraCorr);

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

    public void EscucharLetra(char letraCorr) {
        switch (letraCorr) {
            case 'A':
                btnaudios.setOnClickListener(view -> a.start());
                break;
            case 'B':
                btnaudios.setOnClickListener(view -> b.start());
                break;
            case 'C':
                btnaudios.setOnClickListener(view -> c.start());
                break;
            case 'D':
                btnaudios.setOnClickListener(view -> d.start());
                break;
            case 'E':
                btnaudios.setOnClickListener(view -> e.start());
                break;
            case 'F':
                btnaudios.setOnClickListener(view -> f.start());
                break;
            case 'G':
                btnaudios.setOnClickListener(view -> g.start());
                break;
            case 'H':
                btnaudios.setOnClickListener(view -> h.start());
                break;
            case 'I':
                btnaudios.setOnClickListener(view -> i.start());
                break;
            case 'J':
                btnaudios.setOnClickListener(view -> j.start());
                break;
            case 'K':
                btnaudios.setOnClickListener(view -> k.start());
                break;
            case 'L':
                btnaudios.setOnClickListener(view -> l.start());
                break;
            case 'M':
                btnaudios.setOnClickListener(view -> m.start());
                break;
            case 'N':
                btnaudios.setOnClickListener(view -> n.start());
                break;
            //case 'Ñ':
               // btnaudios.setOnClickListener(view -> ñ.start());
               // break;
            case 'O':
                btnaudios.setOnClickListener(view -> o.start());
                break;
            case 'P':
                btnaudios.setOnClickListener(view -> p.start());
                break;
            case 'Q':
                btnaudios.setOnClickListener(view -> q.start());
                break;
            case 'R':
                btnaudios.setOnClickListener(view -> r.start());
                break;
            case 'S':
                btnaudios.setOnClickListener(view -> s.start());
                break;
            case 'T':
                btnaudios.setOnClickListener(view -> t.start());
                break;
            case 'U':
                btnaudios.setOnClickListener(view -> u.start());
                break;
            case 'V':
                btnaudios.setOnClickListener(view -> v.start());
                break;
            case 'W':
                btnaudios.setOnClickListener(view -> w.start());
                break;
            case 'X':
                btnaudios.setOnClickListener(view -> x.start());
                break;
            case 'Y':
                btnaudios.setOnClickListener(view -> y.start());
                break;
            case 'Z':
                btnaudios.setOnClickListener(view -> z.start());
                break;


        }

    }

    public void crearAudios(){
        mediaPlayer = MediaPlayer.create(this, R.raw.duolingo_correct);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.duolingo_wrong);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.complete);
        a = MediaPlayer.create(this, R.raw.letraa);
        b = MediaPlayer.create(this,R.raw.letrab);
        c = MediaPlayer.create(this,R.raw.letrac);
        d = MediaPlayer.create(this,R.raw.letrad);
        e = MediaPlayer.create(this,R.raw.letrae);
        f = MediaPlayer.create(this,R.raw.letraf);
        g = MediaPlayer.create(this,R.raw.letrag);
        h = MediaPlayer.create(this,R.raw.letrah);
        i = MediaPlayer.create(this,R.raw.letrai);
        j = MediaPlayer.create(this,R.raw.letraj);
        k = MediaPlayer.create(this,R.raw.letrak);
        l = MediaPlayer.create(this,R.raw.letral);
        m = MediaPlayer.create(this,R.raw.letram);
        n = MediaPlayer.create(this,R.raw.letran);
        //ñ = MediaPlayer.create(this,R.raw.letraenie);
        o = MediaPlayer.create(this,R.raw.letrao);
        p = MediaPlayer.create(this,R.raw.letrap);
        q = MediaPlayer.create(this,R.raw.letraq);
        r = MediaPlayer.create(this,R.raw.letrar);
        s = MediaPlayer.create(this,R.raw.letras);
        t = MediaPlayer.create(this,R.raw.letrat);
        u = MediaPlayer.create(this,R.raw.letrau);
        v = MediaPlayer.create(this,R.raw.letrav);
        w = MediaPlayer.create(this,R.raw.letraw);
        x = MediaPlayer.create(this,R.raw.letrax);
        y = MediaPlayer.create(this,R.raw.letray);
        z = MediaPlayer.create(this,R.raw.letraz);
    }
}
