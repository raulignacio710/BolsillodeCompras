package com.example.bolsillodecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void mostrar (View v){
        Toast.makeText(this,"JIJI me presionaste", Toast.LENGTH_SHORT).show();
        Intent nueva = new Intent(this,ListaMain.class);
        startActivity(nueva);
    }
}
