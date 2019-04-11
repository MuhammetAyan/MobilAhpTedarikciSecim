package com.example.mobilahptedarikcisecim;

import android.widget.ProgressBar;

public class Tedarikci {

    private String isim;
    private String deger;

    public Tedarikci(String isim,String deger){
        this.isim=isim;
        this.deger=deger;
    }
    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getDeger() {
        return deger;
    }

    public void setDeger(String deger) {
        this.deger = deger;
    }




}
