package com.example.mobilahptedarikcisecim;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TedarikciSorgula2 extends AppCompatActivity {
    List<Tedarikci> urunler;
    TedarikciAdaptor adaptor;
    ListView urunlist;
    String adres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tedarikci_sorgula2);

        TextView tedarikciadres=findViewById(R.id.textView3);
        urunlist =findViewById(R.id.urunler);

      //   new TedarikciServis().execute("http://192.168.43.91:8080/tedarikcisorgula/listele/<arama>");

        Bundle veri=getIntent().getExtras();
       adres =veri.getString("Tedarikci");
        tedarikciadres.setText(adres);
////silinecek
        urunler =new ArrayList<>();
        urunler.add(new Tedarikci("Ali","20"));
        urunler.add(new Tedarikci("Ali","70"));
        urunler.add(new Tedarikci("Ali","30"));
        urunler.add(new Tedarikci("Ali","50"));
        urunler.add(new Tedarikci("Ali","20"));
        urunler.add(new Tedarikci("Ali","10"));
        urunler.add(new Tedarikci("Ali","23"));
        urunler.add(new Tedarikci("Ali","20"));
/////silinecek
         adaptor=new TedarikciAdaptor(TedarikciSorgula2.this,urunler);
        urunlist.setAdapter(adaptor);
    }

  /*   private class TedarikciServis extends AsyncTask<String,String,List<Tedarikci>> {


        @Override
        protected List<Tedarikci> doInBackground(String... params) {

            WebServise servis=new WebServise();
            servis.BaglantiKur(params[0],"GET");
            JSONObject jy=new JSONObject();
            try {
                jy.put("id",adres);
                servis.Istek(jy);
                JsonIslem islem = new JsonIslem();
                urunler=islem.JsonToTedarikci(servis.Yanıt());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return urunler;
        }
        @Override
        protected void onPostExecute(List<Tedarikci> urunler){
            super.onPostExecute(urunler);
            adaptor=new TedarikciAdaptor(TedarikciSorgula2.this,urunler);
            urunlist.setAdapter(adaptor);
        }
    }*/
}
