package com.example.examen_alvarezlopezsaul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView contador;
    Button btnsalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//metodo onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irActividad(View v) {//metodo para cambiar de una actividad a otra
        Intent i = new Intent(getApplicationContext(), Pantalla2.class);
        startActivity(i);
    }

    public void salir(View v) {//metodo para salir de la aplicacion con dos tipos distintos
//        finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

}