package com.example.bolsillodecompras;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class ListaMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void terminar_lista(View v){
        Toast.makeText(this,"La Lista de compras ha sido Terminada", Toast.LENGTH_SHORT).show();
        Intent nueva = new Intent(this,MainActivity.class);
        startActivity(nueva);
    }
    public void Nuevo_producto(View v){
        Intent nueva = new Intent(this,ListaAgregar.class);
        startActivity(nueva);
    }
}
