package com.example.mobilahptedarikcisecim;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;

public class TSS_Menu extends AppCompatActivity{
    private PieGrafik grafik;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tss__menu);
        PieChart pie=findViewById(R.id.pie);
        grafik =new PieGrafik(pie);
        Button tumunuhesapla= findViewById(R.id.tumunuhesapla);
        Button stratejibelirle=findViewById(R.id.stratejibelirle);
        Button tedarikcisorgula=findViewById(R.id.tedarikcisorgula);
        Button urunsorgula=findViewById(R.id.urunsorgula);

        dialog=new Dialog(this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);

        new GrafikServis().execute("http://192.168.43.91:8080/app/grafik");

        stratejibelirle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),StratejiBelirle.class);
                startActivity(intent);

            }
        });

        tedarikcisorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),TedarikciSorgula.class);
                startActivity(intent);
            }
        });
        urunsorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),UrunSorgula.class);
                startActivity(intent);
            }
        });
        tumunuhesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                new TumunuHesaplaServis().execute("http://192.168.43.91:8080/app/grafik");
            }
        });

    }

    private class GrafikServis extends AsyncTask<String,Void,Integer> {


        @Override
        protected Integer doInBackground(String... strings) {
            try {
                //  WebServise servise = new WebServise();
                // servise.BaglantiKur(strings[0], "GET");
                //JSONObject jo = servise.Yanıt();
                //Integer deger = Integer.parseInt(jo.getString(""));
                return 50;
            }catch(Exception e){

            }
            return null;
        }
        @Override
        protected void onPostExecute(Integer progress){
            super.onPostExecute(progress);
            grafik.SetData(progress);
        }
    }
    private class TumunuHesaplaServis extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... params) {

            try {
               Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return params[0];
        }
        @Override
        protected void onPostExecute(String str){
            super.onPostExecute(str);
            dialog.dismiss();

        }
    }
}
