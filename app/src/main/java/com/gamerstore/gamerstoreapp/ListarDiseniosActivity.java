package com.gamerstore.gamerstoreapp;

import android.app.LauncherActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
    JSONParser jParser= new JSONParser();
    ArrayList<HashMap<String,String>> diseniosLista;

    //URL
    private static String url_all_disenios= "http://gamerstoreperu.000webhostapp.com/json/disenios/listar_disenios.php";


    //JSON Node nombres
    private static final String TAG_SUCCESS= "Completado";
    private static final String TAG_DISENIOS= "disenios";
    private static final String TAG_DID="id";
    private static final String TAG_DESCRIPCION="descripcion";

    JSONArray misdisenios= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_disenios);

        diseniosLista=new ArrayList<HashMap<String, String>>();
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

    class CargarDisenios extends AsyncTask<String, String, String>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog= new ProgressDialog(ListarDiseniosActivity.this);
            pDialog.setMessage("Cargando Diseño. Por favor espere...");
            pDialog.setIndeterminate(false);

            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(String... args){
            List<NameValuePair> params= new ArrayList<NameValuePair>();
            JSONObject json= jParser.makeHttpRequest(url_all_disenios,"GET",params);
            Log.d("Todos los Diseños: ",json.toString());

            try {
                int success= json.getInt(TAG_SUCCESS);
                if (success==1){
                    misdisenios=json.getJSONArray(TAG_DISENIOS);

                    for (int i=0; i<misdisenios.length();i++){
                        JSONObject c= misdisenios.getJSONObject(i);

                        String id= c.getString(TAG_DID);
                        String descripcion= c.getString(TAG_DESCRIPCION);

                        HashMap<String,String> map=new HashMap<String, String>();

                        map.put(TAG_DID,id);
                        map.put(TAG_DESCRIPCION,descripcion);

                        diseniosLista.add(map);
                    }
                }else {
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /*protected void onPostExecute(String file_url){
            pDialog.dismiss();

            runOnUiThread(new Runnable() {

                public void run() {
                    ListAdapter adapter= new SimpleAdapter((ListarDiseniosActivity.this, diseniosLista,R.layout.))
                }
            });
        }*/
    }
}
