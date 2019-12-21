package com.gamerstore.gamerstoreapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listar(View view) {
        Intent intent = new Intent(getApplicationContext(), ListarDiseniosActivity.class);
        startActivity(intent);
    }

    public void salir(View view) {
        finish();
    }
}
