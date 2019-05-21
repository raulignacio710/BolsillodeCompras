package com.example.bolsillodecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.Spinner;

public class ListaAgregar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agregar);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] letra = {"Ninguna","Bebestibles","Conservas","Higiene","Hogar","Tecnologia"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letra));
    }
    public void Agregar_producto(View v){
        Toast.makeText(this,"Producto Agregado", Toast.LENGTH_SHORT).show();
        Intent nueva = new Intent(this,ListaMain.class);
        startActivity(nueva);
    }
}
