package com.example.mobilahptedarikcisecim;

import android.graphics.Color;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieGrafik {
    private PieChart pie;
    public PieGrafik(PieChart pie)
    {   this.pie=pie;
        //  pie.setBackgroundColor(Color.WHITE);
      //  pie.setUsePercentValues(true);

        pie.getDescription().setEnabled(false);
        pie.setHoleColor(Color.rgb(170,170,170));
        pie.setTransparentCircleRadius(0);
        pie.setRotationAngle(180);
        pie.animateY(1000, Easing.EaseInOutCubic);
        pie.getLegend().setEnabled(false);
    }
    public void SetData(int angle){
        ArrayList<PieEntry> values=new ArrayList<>();

            values.add(new PieEntry(angle,"Tedarikçi"));
        pie.setMaxAngle(angle);
        PieDataSet dataset=new PieDataSet(values,"Partner");
        dataset.setSelectionShift(5f);
        dataset.setSliceSpace(3f);
        dataset.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data=new PieData(dataset);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.WHITE);

        pie.setData(data);
        pie.invalidate();
    }
}
