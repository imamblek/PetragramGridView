package com.imamblek.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityAcercade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);
        androidx.appcompat.widget.Toolbar miActionBar = findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);


        // para activar el boton de regreso.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}