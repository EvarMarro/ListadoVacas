package com.example.evar.listadovacas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Evar on 08/08/2017.
 */

public class AdapterDatos extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Vaca> items;

    public AdapterDatos(Activity activity, ArrayList<Vaca> items){
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_lista_vacas, null);
        }
        Vaca vaca = items.get(position);
        ImageView foto = (ImageView) v.findViewById(R.id.imageView_vaca);
        foto.setImageDrawable(vaca.getFoto());
        TextView nombre = (TextView) v.findViewById(R.id.textView_nombre);
        nombre.setText(vaca.getNombre());
        TextView info = (TextView) v.findViewById(R.id.textView_info);
        info.setText(vaca.getInfo());
        return v;
    }
}
