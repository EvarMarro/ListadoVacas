package com.example.evar.listadovacas.DbHelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Evar on 11/08/2017.
 */

public class VacaDbHelper extends SQLiteOpenHelper {

    public static abstract class VacaEntry implements BaseColumns {
        public static final String TABLE_NAME ="vaca";
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String INFO = "info";
        public static final String IMAGEN = "imagen";
    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Vacas.db";
    public VacaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String CrearTabla =
            "CREATE TABLE " + VacaEntry.TABLE_NAME + " ("
                    + VacaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + VacaEntry.ID + " TEXT NOT NULL,"
                    + VacaEntry.NOMBRE + " TEXT NOT NULL,"
                    + VacaEntry.INFO + " TEXT NOT NULL,"
                    + VacaEntry.IMAGEN + " TEXT NOT NULL,"
                    + "UNIQUE (" + VacaEntry.ID + "))";

    private static final String DropearTabla = "DROP TABLE IF EXISTS " + VacaEntry.TABLE_NAME;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CrearTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DropearTabla);
        onCreate(db);
    }
}
