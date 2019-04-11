package com.example.mobilahptedarikcisecim;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class UrunSorgula extends AppCompatActivity {

    ListView urunlist;
    ArrayAdapter<String> adapter;
   ArrayList<String> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun_sorgula);

        urunlist = findViewById(R.id.searchurun);

       // new UrunServis().execute("http://192.168.43.91:8080/urunlerisorgula/urunler/<arama>");
        array=new ArrayList<>();

        array.addAll(Arrays.asList(getResources().getStringArray(R.array.urun)));
        adapter =new ArrayAdapter<String>(UrunSorgula.this,android.R.layout.simple_list_item_1,array);
        urunlist.setAdapter(adapter);

        urunlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String deger= array.get(i);
                Intent intent=new Intent(UrunSorgula.this,UrunSorgula2.class);
                intent.putExtra("urun",deger);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        Search item = new Search();
        menu = item.SearchItem(menu, inflater, adapter);
        return super.onCreateOptionsMenu(menu);


    }

    /*private class UrunServis extends AsyncTask<String,String,ArrayList<String>>{


        @Override
        protected ArrayList<String> doInBackground(String... params) {

            WebServise servis=new WebServise();
            servis.BaglantiKur(params[0],"GET");
            JsonIslem islem = new JsonIslem();
           array=islem.JsonToString(servis.Yanıt());
            return array;
        }
        @Override
        protected void onPostExecute(ArrayList<String> dizi){
            super.onPostExecute(dizi);
            adapter=new ArrayAdapter<String>(UrunSorgula.this,android.R.layout.simple_list_item_1,dizi);
            urunlist.setAdapter(adapter);
        }
    }*/
}
