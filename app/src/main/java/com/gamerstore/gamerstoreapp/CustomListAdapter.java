package com.gamerstore.gamerstoreapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<ListItem> listData;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context context, ArrayList<ListItem> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDisenio misdisenios;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item, null);
            misdisenios = new ViewDisenio();
            misdisenios.prodId 		    = (TextView) convertView.findViewById(R.id.id);
            misdisenios.prodDescripcion	= (TextView) convertView.findViewById(R.id.descripcion);
            misdisenios.prodImagen	= (TextView) convertView.findViewById(R.id.imagen);
            misdisenios.prodCategoria	= (TextView) convertView.findViewById(R.id.categoria);
            misdisenios.prodPrecioUnitario	= (TextView) convertView.findViewById(R.id.preciounitario);
            convertView.setTag(misdisenios);

        } else {
            misdisenios = (ViewDisenio) convertView.getTag();
        }

        ListItem newsItem = (ListItem) listData.get(position);

        misdisenios.prodId.setText(newsItem.getProdId());
        misdisenios.prodDescripcion.setText(newsItem.getProdDescripcion());
        misdisenios.prodImagen.setText(newsItem.getProdImagen());
        misdisenios.prodCategoria.setText(newsItem.getProdCategoria());
        misdisenios.prodPrecioUnitario.setText(newsItem.getProdPreciounitario());
        return convertView;
    }

    static class ViewDisenio {

        TextView prodId;
        TextView prodDescripcion;
        TextView prodImagen;
        TextView prodCategoria;
        TextView prodPrecioUnitario;


    }


}
