package com.example.mobilahptedarikcisecim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class StratejiBelirle2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strateji_belirle2);



        SeekBar[] seekBar=new SeekBar[6];
        LinearLayout lineer=findViewById(R.id.linearbar);
        for(int i=0;i<6;i++){
            seekBar[i]=new SeekBar(this);
            seekBar[i].setMax(100);

            lineer.addView(seekBar[i],ViewGroup.LayoutParams.MATCH_PARENT,300);
        }
    }
}
