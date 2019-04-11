package com.example.mobilahptedarikcisecim;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonIslem {

    public ArrayList<String> JsonToString(JSONObject j){
       ArrayList<String> array=new ArrayList<>();
        try {
           JSONArray jsonarray= j.getJSONArray("Item");
            for(int i=0;i<jsonarray.length();i++){
                array.add(jsonarray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return array;
    }
    public JSONObject StringToJson(){
        return null;
    }

    public List<Tedarikci> JsonToTedarikci(JSONObject j){
        List<Tedarikci> array=new ArrayList<>();
        try{
            JSONArray jsonArray=j.getJSONArray("Item");
            for (int i=0;i<jsonArray.length();i++){
                Tedarikci tedarikci=new Tedarikci(jsonArray.getString(0),jsonArray.getString(1));
                array.add(tedarikci);
            }


        }catch(JSONException e){
            e.printStackTrace();
        }
        return array;
    }
}
