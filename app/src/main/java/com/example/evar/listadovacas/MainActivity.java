package com.example.evar.listadovacas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.evar.listadovacas.DbHelpers.VacaDbHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillListViewVacas();
    }

    private void fillListViewVacas() {
        ListView lista = (ListView)findViewById(R.id.listView_vacas);


        AdapterDatos adapterDatos = new AdapterDatos(this, buscarVacas());
        lista.setAdapter(adapterDatos);
    }

    private ArrayList<Vaca> buscarVacas(){
        ArrayList<Vaca> arrayDatos = new ArrayList<Vaca>();

        VacaDbHelper dbHelper = new VacaDbHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + VacaDbHelper.VacaEntry.TABLE_NAME, null);
        while(c.moveToNext()){
            String nombre = c.getString(c.getColumnIndex(VacaDbHelper.VacaEntry.NOMBRE));
            String info = c.getString(c.getColumnIndex(VacaDbHelper.VacaEntry.INFO));
            Vaca vaca = new Vaca(getResources().getDrawable(R.drawable.vaca1), nombre, info );
            arrayDatos.add(vaca);
        }
        return arrayDatos;
    }
}
