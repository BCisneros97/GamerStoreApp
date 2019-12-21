package com.gamerstore.gamerstoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;

public class ListarDiseniosActivity extends AppCompatActivity {

    private ProgressDialog pDialog;

    //Crear JSON Parser Object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_disenios);
    }
}
