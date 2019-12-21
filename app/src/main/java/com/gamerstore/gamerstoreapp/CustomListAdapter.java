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
            misdisenios.diseId 		    = (TextView) convertView.findViewById(R.id.id);
            misdisenios.diseDescripcion	= (TextView) convertView.findViewById(R.id.descripcion);
            misdisenios.disefoto=(ImageView) convertView.findViewById(R.id.foto);
            misdisenios.categoria=(TextView) convertView.findViewById(R.id.categoria);
            misdisenios.precioenviounitario=(TextView) convertView.findViewById(R.id.preciounitario);

            convertView.setTag(misdisenios);

        } else {
            misdisenios = (ViewDisenio) convertView.getTag();
        }

        ListItem newsItem = (ListItem) listData.get(position);
        misdisenios.diseId.setText(newsItem.getProdIdId());
        misdisenios.diseDescripcion.setText(newsItem.getProdDescripcion());
        misdisenios.precioenviounitario.setText(newsItem.getProdPreciounitario());
        misdisenios.categoria.setText(newsItem.getProdCategoria());

        if (misdisenios.disefoto != null) {
            new ImageDownloaderTask(misdisenios.disefoto).execute(newsItem.getProdImagen());
        }
        return convertView;
    }

    static class ViewDisenio {
        TextView diseId;
        TextView diseDescripcion;
        TextView diseImagen;
        ImageView disefoto;
        TextView categoria;
        TextView precioenviounitario;

    }


}
