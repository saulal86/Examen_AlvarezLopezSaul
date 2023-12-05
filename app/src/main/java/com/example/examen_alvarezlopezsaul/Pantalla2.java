package com.example.examen_alvarezlopezsaul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pantalla2 extends AppCompatActivity {
    TextView cronometro;
    Button btnplay;
    Button btnrecord;
    Button btnpausa;
    int incrementoAutomatico = 1;
    BigInteger cont = BigInteger.ZERO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//metodo onCreate para llamar a todo
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        cronometro = findViewById(R.id.cronometro);
        cronometro.setText(String.valueOf(cont));
        ejecutarHilo();
    }

    public String actualizarTextoContador() {//este metodo se crea para cuando la variable "cont" llega a esos numeros se cambie por un unico numero mas la letra correspondiente
        String textoContador;
        if (cont.compareTo(BigInteger.valueOf(1000)) >= 0) {
            BigInteger mil = BigInteger.valueOf(1000);
            BigInteger cantidad = cont.divide(mil);
            textoContador = cantidad + " k";
        }
        if (cont.compareTo(BigInteger.valueOf(1000000)) >= 0) {
            BigInteger Mill = BigInteger.valueOf(1000000);
            BigInteger cantidad_2 = cont.divide(Mill);
            textoContador = cantidad_2 + " Mill";
        } else {
            textoContador = cont.toString();
        }
        cronometro.setText(textoContador);
        return textoContador;
    }

    public void ejecutarHilo() {//metodo para que el cronometro vaya sumando de uno en uno
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cont = cont.add(BigInteger.valueOf(incrementoAutomatico));

                handler.post(() -> {
                    cronometro.setText(actualizarTextoContador());

                });
            }
        });
    }


}