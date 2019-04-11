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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class TedarikciSorgula extends AppCompatActivity {
    ListView tedarikcilist;
    ArrayAdapter<String> adapter;
    ArrayList<String> array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tedarikci_sorgula);
        tedarikcilist = findViewById(R.id.searchtedarikci);

        // new TedarikciServis().execute("http://192.168.43.91:8080/tedarikcisorgula/listele/<arama>");
        array=new ArrayList<>();
///////// silinecek
        array.addAll(Arrays.asList(getResources().getStringArray(R.array.urun)));
        adapter =new ArrayAdapter<String>(TedarikciSorgula.this,android.R.layout.simple_list_item_1,array);
        tedarikcilist.setAdapter(adapter);
/////////
        tedarikcilist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String deger= array.get(i);
                Intent intent=new Intent(TedarikciSorgula.this,TedarikciSorgula2.class);
                intent.putExtra("Tedarikci",deger);
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

    /* private class TedarikciServis extends AsyncTask<String,String,ArrayList<String>> {


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
            adapter=new ArrayAdapter<String>(TedarikciSorgula.this,android.R.layout.simple_list_item_1,dizi);
            tedarikcilist.setAdapter(adapter);
        }
    }*/

}
