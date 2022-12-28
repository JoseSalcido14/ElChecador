package com.example.elchecador.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NOMBRE = "checador.db";
    public static final String TABLE_EMPLEADOS = "t_empleados";
    public static final String TABLE_FUNCIONES = "t_funciones";
    public static final String TABLE_MARCADORES = "t_marcadores";
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EMPLEADOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "correo_electronico TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_FUNCIONES + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "correo_electronico TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_MARCADORES + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "hora DATETIME NOT NULL," +
                "foreign key(id_empleado) references TABLA_EMPLEADOS(id),"+
                "foreign key(id_funcion) references TABLA_FUNCIONES(id))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_EMPLEADOS);
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_FUNCIONES);
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_MARCADORES);
        onCreate(sqLiteDatabase);
    }
}

