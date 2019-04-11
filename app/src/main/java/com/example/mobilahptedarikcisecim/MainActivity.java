package com.example.mobilahptedarikcisecim;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

  private String key=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button girisyap=findViewById(R.id.girisyap);
        final EditText kullaniciadi=findViewById(R.id.KullaniciAdi);
        final EditText sifre=findViewById(R.id.Sifre);
        kullaniciadi.setText("Muhammet");
        sifre.setText("1234");

        girisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   new GirisYapServis().execute("http://192.168.43.91:8080/account/login",kullaniciadi.getText().toString(),sifre.getText().toString());
                Intent intent = new Intent(MainActivity.this, TSS_Menu.class);
                startActivity(intent);
            }
        });
    }
    class GirisYapServis extends AsyncTask<String,Void,Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                WebServise servis=new WebServise();
                servis.BaglantiKur(params[0],"POST");
                JSONObject jy = new JSONObject();
                jy.put("username", params[1]);
                jy.put("password", params[2]);
                servis.Istek(jy);
                JSONObject jo=servis.Yanıt();
                key = jo.getString("auth");
                return true;
            } catch (Exception e) {
            }
            return false;
        }
        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if (result) {
                Intent intent = new Intent(MainActivity.this, TSS_Menu.class);
                startActivity(intent);
            }
          //  else Toast.makeText(getApplicationContext(),"kullanıcı adı veya şifreniz yanlış..",Toast.LENGTH_LONG).show();
        }

    }

    }
