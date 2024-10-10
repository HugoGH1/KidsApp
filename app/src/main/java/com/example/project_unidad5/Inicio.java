package com.example.project_unidad5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    Button btnJugar;
    TextView txtNombre;
    EditText editNombre;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        txtNombre = findViewById(R.id.txtNombre);
        btnJugar = findViewById(R.id.btnJugar);
        editNombre = findViewById(R.id.editNombre);

        SharedPreferences miNombre = getSharedPreferences("datos", Context.MODE_PRIVATE);
        txtNombre.setText(miNombre.getString("elDato",""));

        if(!txtNombre.getText().equals("")){
            editNombre.setVisibility(View.INVISIBLE);
        }
        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editNombre.getText().toString();
                SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("elDato",name);
                editor.commit();

                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}