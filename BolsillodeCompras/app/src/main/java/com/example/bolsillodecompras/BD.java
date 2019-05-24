package com.example.bolsillodecompras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class BD extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BolsilloCompras.db";

    public static final String TABLA_NOMBRES = "Lista";
    public static final String COLUMNA_ID = "_id";
    public static final String COLUMNA_NOMBRE1 = "Nombre";
    public static final String COLUMNA_NOMBRE2 = "Categoria";


    private static final String SQL_CREAR  = "create table "
            + TABLA_NOMBRES + "(" + COLUMNA_ID
            + " integer primary key autoincrement, " + COLUMNA_NOMBRE1
            + " text not null ," + COLUMNA_NOMBRE2 + " text not null"+ ")";
    private static final String q="drop table Lista";


    public BD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREAR);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void obtener(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMNA_ID, COLUMNA_NOMBRE1,COLUMNA_NOMBRE2};

        Cursor cursor =
                db.query(TABLA_NOMBRES,
                        projection,
                        " _id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);


        if (cursor != null)
            cursor.moveToFirst();

        System.out.println("El nombre es " +  cursor.getString(1) );
        db.close();

    }
}
