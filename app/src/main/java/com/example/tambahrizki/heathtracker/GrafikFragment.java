package com.example.tambahrizki.heathtracker;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GrafikFragment extends Fragment {


    public GrafikFragment() {
        // Required empty public constructor
    }
    BarChart chart;
    ArrayList<BarEntry> barEntries;
    ArrayList<String> barLabels;
    BarDataSet barDataSet;
    BarData barData;

    DbHelper dbHelper;
    protected Cursor cursor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_grafik, container, false);

        chart = (BarChart) view.findViewById(R.id.chart);

        barEntries = new ArrayList<BarEntry>();
        barLabels = new ArrayList<String>();

        dbHelper = new DbHelper(getContext());

        SQLiteDatabase dbhit = dbHelper.getReadableDatabase();
        cursor = dbhit.rawQuery("SELECT * FROM beratbadan;", null);
        cursor.moveToFirst();

//        barLabels.add("ssssss");// index 0 kosongkan saja
        for (int i = 0; i <cursor.getCount() ; i++) {
            cursor.moveToPosition(i);
            barEntries.add(new BarEntry(cursor.getInt(0), cursor.getInt(1)));
            barLabels.add("Workout ke -"+cursor.getCount());
        }
//        barEntries.add(new BarEntry(2, 25f));
//        barLabels.add("Hari 2");
//        barEntries.add(new BarEntry(3, 24f));
//        barLabels.add("Hari 3");

        barDataSet = new BarDataSet(barEntries, "Berat Badan");

        barData = new BarData(barDataSet);
        chart.getXAxis().setValueFormatter(
                new IndexAxisValueFormatter(barLabels));

        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(barData);

        chart.animateY(3000);

        return view;
    }

}
