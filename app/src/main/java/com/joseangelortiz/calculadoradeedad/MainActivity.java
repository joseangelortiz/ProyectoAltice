package com.joseangelortiz.calculadoradeedad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imageButtonFechas).setOnClickListener((v) -> {
            startActivity(new Intent(this, CalculadoraDeEdadActivity.class));
        });

        findViewById(R.id.imageButtonEdadCanina).setOnClickListener((v) -> {
            startActivity(new Intent(this, CalculadoraDeEdadCaninaActivity.class));
        });


    }

}
