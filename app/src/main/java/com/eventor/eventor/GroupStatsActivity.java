package com.eventor.eventor;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class GroupStatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_stats);
        BarChart chart = (BarChart) findViewById(R.id.chart);

        BarData data = new BarData(getXAxisValues(), getDataSet());
        chart.setDescription("");
        chart.setData(data);
        chart.animateXY(2000, 2000);
        chart.invalidate();
    }

    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(5, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(7, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(10, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(8, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(15, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(24, 5); // Jun
        valueSet1.add(v1e6);

        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(6, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(9, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(12, 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(25, 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(42, 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(49, 5); // Jun
        valueSet2.add(v2e6);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
        barDataSet2.setColor(Color.rgb(155, 0, 0));

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("8");
        xAxis.add("10");
        xAxis.add("12");
        xAxis.add("14");
        xAxis.add("16");
        xAxis.add("18");
        return xAxis;
    }
}
