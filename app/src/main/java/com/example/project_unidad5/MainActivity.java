package com.example.project_unidad5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView fondo_mar;
    Button btnSumas, btnContar,btnResta,btnSonidos, btnInicial,Comp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fondo_mar = findViewById(R.id.fondo_mar);

        btnSumas = findViewById(R.id.btnSumas);
        btnContar = findViewById(R.id.btnContar);
        btnResta = findViewById(R.id.btnResta);
        btnSonidos = findViewById(R.id.btnSonidos);
        btnInicial = findViewById(R.id.btnInical);
        Comp = findViewById(R.id.Comp);
        btnSumas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),DificultadSumas.class);
                startActivity(in);
            }
        });
        btnContar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2 = new Intent(getApplicationContext(),Contar.class);
                startActivity(in2);
            }
        });
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getApplicationContext(),DificultadRestas.class);
                startActivity(i3);
            }
        });

        btnSonidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4= new Intent(getApplicationContext(),Sonidos.class);
                startActivity(i4);
            }
        });

        btnInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5= new Intent(getApplicationContext(),Animales.class);
                startActivity(i5);
            }
        });

        Comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6= new Intent(getApplicationContext(),Compite.class);
                startActivity(i6);
            }
        });
    }
}