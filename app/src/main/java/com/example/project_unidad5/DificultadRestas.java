package com.example.project_unidad5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DificultadRestas extends AppCompatActivity {

    Button btnTercero, btnSegundo, btnPrimero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificultad_restas);

        btnPrimero = findViewById(R.id.btnPrimero);
        btnSegundo = findViewById(R.id.btnSegundo);
        btnTercero = findViewById(R.id.btnTercero);

        btnPrimero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),Restas.class);
                startActivity(in);
            }
        });
        btnSegundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2 = new Intent(getApplicationContext(),Restas2.class);
                startActivity(in2);
            }
        });
        btnTercero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in3 = new Intent(getApplicationContext(),Restas3.class);
                startActivity(in3);
            }
        });
    }
}