package com.example.bolsillodecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;
import com.example.bolsillodecompras.BD;

public class ListaAgregar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agregar);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        EditText textbox = (EditText) findViewById(R.id.editText);

        String[] letra = {"Ninguna","Comestibles","Bebestibles","Conservas","Higiene","Hogar","Tecnologia","Otros"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letra));
    }
    public void Agregar_producto(View v){
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        EditText textbox = (EditText) findViewById(R.id.editText);
        BD db = new BD(this,"ListasBD",null,1 );
        SQLiteDatabase Base= db.getWritableDatabase();
        String nom=textbox.getText().toString();
        String cat=spinner.getSelectedItem().toString();
        if(!nom.isEmpty() && !cat.isEmpty()){
            ContentValues values = new ContentValues();
            values.put("Nombre", nom);
            values.put("Categoria",cat);
            Base.insert("Lista", null,values);
            Base.close();
            Toast.makeText(this,"Producto Agregado", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();
        }

        Intent nueva = new Intent(this,ListaMain.class);
        startActivity(nueva);

    }
}
