package com.example.mobilahptedarikcisecim;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServise {
    private  HttpURLConnection connect = null;

    //public HttpURLConnection getConnect() {
      // return connect;
   // }


    public void BaglantiKur(String adres, String method) {

        try {
            URL url = new URL(adres);
            connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod(method);
            connect.setRequestProperty("Content-Type", "application/json");
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setInstanceFollowRedirects(false);
            connect.setUseCaches(false);
            //connect.setRequestProperty("auth","");
            connect.connect();
        }catch (Exception e){

        }
    }
    public void Istek(JSONObject j){
        try {
            DataOutputStream printout = new DataOutputStream(connect.getOutputStream());
            printout.writeBytes(j.toString());
            printout.flush();
            printout.close();
        }catch (Exception e){

        }
    }

    public JSONObject Yanıt(){
        BufferedReader br = null;
        JSONObject jo=null;
        try {
            InputStream is = connect.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            String satir;
            StringBuffer response = new StringBuffer();
            while ((satir = br.readLine()) != null) {
                response.append(satir);
                response.append('\r');
            }
            jo = new JSONObject(response.toString());
            br.close();
        }catch (Exception e){
        }
        return jo;
    }
}
