package com.example.mobilahptedarikcisecim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class TedarikciAdaptor extends BaseAdapter {
    List<Tedarikci> tedarikciler;
    LayoutInflater layoutInflater;

    public  TedarikciAdaptor(Context context,List<Tedarikci> tedarikciler){
        this.tedarikciler=tedarikciler;
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tedarikciler.size();
    }

    @Override
    public Object getItem(int i) {
        return tedarikciler.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item=layoutInflater.inflate(R.layout.list_item_layout,null);
        TextView isim=item.findViewById(R.id.isim);
        ProgressBar gosterge=item.findViewById(R.id.gosterge);
        TextView deger=item.findViewById(R.id.yuzde);

        Tedarikci tedarikci=tedarikciler.get(i);

        isim.setText(tedarikci.getIsim());
        gosterge.setProgress(Integer.parseInt(tedarikci.getDeger()));
        deger.setText(tedarikci.getDeger());
        return item;
    }
}
