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
           /* misdisenios.diseProdID	    = (TextView) convertView.findViewById(R.id.producto_id);
            misdisenios.diseClienteID	= (TextView) convertView.findViewById(R.id.cliente_id);

            misdisenios.diseImagen 	    = (TextView) convertView.findViewById(R.id.imagen);
            misdisenios.diseFoto 	   = (ImageView) convertView.findViewById(R.id.foto);
*/
            convertView.setTag(misdisenios);

        } else {
            misdisenios = (ViewDisenio) convertView.getTag();
        }

        ListItem newsItem = (ListItem) listData.get(position);
        misdisenios.diseId.setText(newsItem.getDiseId());
        misdisenios.diseDescripcion.setText(newsItem.getDiseDescripcion());
    /*    misdisenios.diseProdID.setText(newsItem.getDiseProdID());
        misdisenios.diseClienteID.setText(newsItem.getDiseClienteID());

        misdisenios.diseImagen.setText(newsItem.getDiseImagen());

        if (misdisenios.diseFoto != null) {
            new ImageDownloaderTask(misdisenios.diseFoto).execute(newsItem.getDiseImagen());
        }*/
        return convertView;
    }

    static class ViewDisenio {
        TextView diseId;
        TextView diseDescripcion;
    /*    TextView diseProdID;
        TextView diseClienteID;
        TextView diseImagen;
        ImageView diseFoto;
*/

    }


}
