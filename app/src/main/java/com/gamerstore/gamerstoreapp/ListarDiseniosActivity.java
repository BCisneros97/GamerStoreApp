package com.gamerstore.gamerstoreapp;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListarDiseniosActivity extends ListActivity {

    private ProgressDialog pDialog;

    //Crear JSON Parser Object
    JSONParser jParser = new JSONParser();
    ArrayList<HashMap<String, String>> diseniosLista;

    ArrayList<ListItem> listMockData = new ArrayList<ListItem>();
    //URL
    private static String url_all_disenios = "http://gamerstoreperu.000webhostapp.com/json/disenios/listar_disenios.php";

    //JSON Node nombres
    private static final String TAG_SUCCESS = "Completado";
    private static final String TAG_DISENIOS = "disenios";
    private static final String TAG_DID = "id";
    private static final String TAG_DESCRIPCION = "descripcion";
    private static final String TAG_IMAGEN = "imagen";
    private static final String TAG_PRODNOMBRE = "prodnombre";
    private static final String TAG_PRODCARACTERISTICA = "prodcaracteristic";
    private static final String TAG_PRODPRECIOUNITARIO = "prodpreciounitario";
    private static final String TAG_PRODPRECIOENVIOLOCAL = "prodprecioenviolocal";
    private static final String TAG_PRODPRECIOENVIOPROVINCIA = "prodprecioenvioprovincia";
    private static final String TAG_CATNOMBRE = "catnombre";
    private static final String TAG_USERNOMBRE = "usernombre";

    JSONArray misdisenios = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_disenios);

        diseniosLista = new ArrayList<HashMap<String, String>>();
        new CargarDisenios().execute();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 100) {
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

    }

    class CargarDisenios extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(ListarDiseniosActivity.this);
            pDialog.setMessage("Cargando Diseño. Por favor espere...");
            pDialog.setIndeterminate(false);

            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(String... args) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            JSONObject json = jParser.makeHttpRequest(url_all_disenios, "GET", params);
            Log.d("Todos los Diseños: ", json.toString());

            try {
                int success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    misdisenios = json.getJSONArray(TAG_DISENIOS);

                    for (int i = 0; i < misdisenios.length(); i++) {
                        JSONObject c = misdisenios.getJSONObject(i);


                        ListItem newsData = new ListItem();

                        String id = c.getString(TAG_DID);
                        String descripcion = c.getString(TAG_DESCRIPCION);
                        String categoria = c.getString(TAG_CATNOMBRE);
                        String preciounitario = c.getString(TAG_PRODPRECIOUNITARIO);
                        String imagen = c.getString(TAG_IMAGEN);


                        HashMap<String, String> map = new HashMap<String, String>();

                        map.put(TAG_DID, id);
                        map.put(TAG_DESCRIPCION, descripcion);
                        map.put(TAG_CATNOMBRE, categoria);
                        map.put(TAG_PRODPRECIOUNITARIO, preciounitario);
                        map.put(TAG_IMAGEN, imagen);


                        String ruta = "http://gamerstoreperu.000webhostapp.com/proyecto/img/" + imagen;

                        newsData.setProdIdId(id);
                        newsData.setProdDescripcion(descripcion);
                        newsData.setDiseProdID(ruta);
                        newsData.setProdCategoria("Categoria: "+categoria);
                        newsData.setProdPrecioUnitario("Precio: S/ "+preciounitario+".00");
                        listMockData.add(newsData);


                        diseniosLista.add(map);
                    }
                } else {
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


        protected void onPostExecute(String file_url) {
            pDialog.dismiss();

            runOnUiThread(new Runnable() {

                public void run() {
                    ListAdapter adapter = new SimpleAdapter(ListarDiseniosActivity.this, diseniosLista, R.layout.list_item,
                            new String[]{
                                    TAG_DID,
                                    TAG_DESCRIPCION,
                                    TAG_CATNOMBRE,
                                    TAG_PRODPRECIOUNITARIO,
                                    TAG_IMAGEN
                            }, new int[]{
                            R.id.id,
                            R.id.descripcion,
                            R.id.categoria,
                            R.id.preciounitario,
                            R.id.foto
                    });
                    setListAdapter(adapter);

                    setContentView(R.layout.activity_listar_disenios);
                    final ListView listView = (ListView) findViewById(android.R.id.list);
                    listView.setAdapter(new CustomListAdapter(getBaseContext(), listMockData));
                }
            });
        }
    }
}
