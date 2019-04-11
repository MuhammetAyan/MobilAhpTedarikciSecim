package com.example.mobilahptedarikcisecim;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UrunSorgula2 extends AppCompatActivity {

    List<Tedarikci> tedarikciler;
    ListView tedarikcilist;
    TedarikciAdaptor adaptor;
    String adres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun_sorgula2);

        TextView urunadres=findViewById(R.id.textView7);
        tedarikcilist =findViewById(R.id.tedarikciler);
        // new UrunServis().execute("http://192.168.43.91:8080/urunlerisorgula/tedarikciler/<stokkodu>");

        Bundle veri=getIntent().getExtras();
        adres=veri.getString("urun");
        urunadres.setText(adres);
///// silinecek
        tedarikciler =new ArrayList<>();
        tedarikciler.add(new Tedarikci("Ali","20"));
        tedarikciler.add(new Tedarikci("Ali","70"));
        tedarikciler.add(new Tedarikci("Ali","30"));
        tedarikciler.add(new Tedarikci("Ali","50"));
        tedarikciler.add(new Tedarikci("Ali","20"));
        tedarikciler.add(new Tedarikci("Ali","10"));
        tedarikciler.add(new Tedarikci("Ali","23"));
        tedarikciler.add(new Tedarikci("Ali","20"));
////////
        adaptor=new TedarikciAdaptor(UrunSorgula2.this,tedarikciler);
        tedarikcilist.setAdapter(adaptor);
    }

     /*   private class UrunServis extends AsyncTask<String,String,List<Tedarikci>> {

        @Override
        protected List<Tedarikci> doInBackground(String... params) {

            WebServise servis=new WebServise();
            servis.BaglantiKur(params[0],"GET");
            try{
                JSONObject jy=new JSONObject();
                jy.put("id",adres);
                servis.Istek(jy);
                JsonIslem islem = new JsonIslem();
                tedarikciler=islem.JsonToTedarikci(servis.Yanıt());



            }catch (Exception e){
                e.printStackTrace();
            }
            return tedarikciler;
        }
        @Override
        protected void onPostExecute(List<Tedarikci> tedarikciler){
            super.onPostExecute(tedarikciler);
            adaptor=new TedarikciAdaptor(UrunSorgula2.this,tedarikciler);
            tedarikcilist.setAdapter(adaptor);
        }
    }*/
}
