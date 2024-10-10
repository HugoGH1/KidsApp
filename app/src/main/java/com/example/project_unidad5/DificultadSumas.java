package com.example.project_unidad5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DificultadSumas extends AppCompatActivity {
    Button btnPrimero, btnSegundo, btnTercero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificultad_sumas);

        btnPrimero = findViewById(R.id.btnPrimero);
        btnSegundo = findViewById(R.id.btnSegundo);
        btnTercero = findViewById(R.id.btnTercero);

        btnPrimero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),Sumas.class);
                startActivity(in);
            }
        });

        btnSegundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2 = new Intent(getApplicationContext(),Sumas2.class);
                startActivity(in2);
            }
        });

        btnTercero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in3 = new Intent(getApplicationContext(),Sumas3.class);
                startActivity(in3);
            }
        });
    }
}