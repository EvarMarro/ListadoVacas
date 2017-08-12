package com.example.evar.listadovacas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evar.listadovacas.DbHelpers.VacaDbHelper;

import org.w3c.dom.Text;

public class CrearVacaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_vaca);
    }

    public void guardar(View v){
        VacaDbHelper dbHelper = new VacaDbHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        EditText id = (EditText) findViewById(R.id.id);
        EditText imagen = (EditText) findViewById(R.id.imagen);
        EditText info = (EditText) findViewById(R.id.info);
        EditText nombre = (EditText) findViewById(R.id.nombre);

        values.put(VacaDbHelper.VacaEntry.ID, id.getText().toString());
        values.put(VacaDbHelper.VacaEntry.IMAGEN, imagen.getText().toString());
        values.put(VacaDbHelper.VacaEntry.INFO, info.getText().toString());
        values.put(VacaDbHelper.VacaEntry.NOMBRE, nombre.getText().toString());

        Long idGuardado = db.insert(VacaDbHelper.VacaEntry.TABLE_NAME, VacaDbHelper.VacaEntry.ID, values);
        Toast.makeText(getApplicationContext(), "Se guardo la vaca con Id: " + idGuardado, Toast.LENGTH_LONG).show();
    }
}
