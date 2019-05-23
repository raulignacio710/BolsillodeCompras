package com.example.bolsillodecompras;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListaMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView txt= (TextView) findViewById(R.id.textView_1);
        ListView lv= (ListView) findViewById(R.id.listaview);

        ArrayList<String> lista = new ArrayList<>();

        BD db = new BD(this,"ListasBD",null,1 );
        SQLiteDatabase Base= db.getWritableDatabase();
        Cursor fila = Base.rawQuery("select * from lista", null);
        if(fila.moveToFirst()){
            lista.add(fila.getString(1));
            ArrayAdapter adaptador= new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
            lv.setAdapter(adaptador);
            //txt.setText(lista.get(0));
        }
        else{
            txt.setText("Toy terrible vacio");
        }

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
