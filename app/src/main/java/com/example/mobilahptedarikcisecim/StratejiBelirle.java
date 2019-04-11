package com.example.mobilahptedarikcisecim;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import javax.xml.transform.Result;


public class StratejiBelirle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strateji_belirle);
     //   LinearLayout lineer=findViewById(R.id.lineer);
        PieChart pie=findViewById(R.id.piechart);
       Legend l= pie.getLegend();
       l.setEnabled(false);
       pie.setUsePercentValues(true);
        pie.getDescription().setEnabled(false);
       // pie.setExtraOffsets(5,10,5,5);
      //  pie.setDragDecelerationFrictionCoef(0.95f);
        pie.setDrawHoleEnabled(true);
        //pie.setHoleColor(Color.WHITE);
       // pie.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> ydegerleri=new ArrayList<PieEntry>();
        ydegerleri.add(new PieEntry(10,"Kalite"));
        ydegerleri.add(new PieEntry(23,"Maliyet"));
        ydegerleri.add(new PieEntry(14,"?"));


        PieDataSet dataset=new PieDataSet(ydegerleri,null);
        dataset.setSliceSpace(3f);
        dataset.setSelectionShift(5f);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData data=new PieData(dataset);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.CYAN);

        pie.setData(data);
    }
}
