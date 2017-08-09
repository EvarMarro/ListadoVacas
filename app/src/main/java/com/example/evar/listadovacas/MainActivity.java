package com.example.evar.listadovacas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView)findViewById(R.id.listView_vacas);
        ArrayList<Datos> arrayDatos = new ArrayList<Datos>();
        Datos datos = new Datos(getResources().getDrawable(R.drawable.vaca1), "Vaca 1", "Vaca de cria" );
        arrayDatos.add(datos);
        datos = new Datos(getResources().getDrawable(R.drawable.vaca2), "Vaca 2", "Vaca de engorde" );
        arrayDatos.add(datos);

        AdapterDatos adapterDatos = new AdapterDatos(this, arrayDatos);
        lista.setAdapter(adapterDatos);
    }
}
