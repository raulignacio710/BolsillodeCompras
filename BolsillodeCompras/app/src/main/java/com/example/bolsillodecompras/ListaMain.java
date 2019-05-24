package com.example.bolsillodecompras;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListaMain extends AppCompatActivity {
    public ArrayList<String> listaid = new ArrayList<>();
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
            do{
                String id=fila.getString(0);
                String filita="- "+fila.getString(1)+"/Categoria: "+ fila.getString(2);
                lista.add(filita);
                listaid.add(id);
            }while(fila.moveToNext());
            ArrayAdapter adaptador= new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
            lv.setAdapter(new MyListAdaper(this, R.layout.estructura_lista, lista));
            //txt.setText(lista.get(0));
        }
        else{
            txt.setText("Toy terrible vacio");
        }
    }
    public void terminar_lista(View v){
        BD db = new BD(this,"ListaBD", null, 1);// Debes poner el nombre de la base de datos
        SQLiteDatabase c=db.getWritableDatabase();
        String q= "Delete  from  lista";
        c.execSQL(q);
        db.close();
        Toast.makeText(this,"La Lista de compras ha sido Terminada", Toast.LENGTH_SHORT).show();
        Intent nueva = new Intent(this,MainActivity.class);
        startActivity(nueva);
    }
    public void Nuevo_producto(View v){
        Intent nueva = new Intent(this,ListaAgregar.class);
        startActivity(nueva);
    }
    public void borrar_producto(String id){
        BD db = new BD(this,"ListaBD", null, 1);// Debes poner el nombre de la base de datos
        SQLiteDatabase c=db.getWritableDatabase();
        String q= "Delete  from  lista where _id="+id;
        c.execSQL(q);
        Toast.makeText(getApplicationContext(),"Producto eliminado",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private class MyListAdaper extends ArrayAdapter<String> {
        private int layout;
        private List<String> mObjects;
        private MyListAdaper(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            mObjects = objects;
            layout = resource;
        }

        @SuppressLint("WrongViewCast")
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewholder = null;
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.title = (TextView) convertView.findViewById(R.id.texto);
                viewHolder.button = (Button) convertView.findViewById(R.id.but_eliminar);
                convertView.setTag(viewHolder);
            }
            mainViewholder = (ViewHolder) convertView.getTag();
            mainViewholder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=(int) position;
                    borrar_producto(listaid.get(pos));
                    finish();
                    startActivity(getIntent());
                }
            });
            mainViewholder.title.setText(getItem(position));

            return convertView;
        }
    }
    public class ViewHolder {
        TextView title;
        Button button;
    }
}
