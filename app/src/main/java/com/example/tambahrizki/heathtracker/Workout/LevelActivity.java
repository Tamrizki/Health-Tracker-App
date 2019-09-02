package com.example.tambahrizki.heathtracker.Workout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tambahrizki.heathtracker.AdapterListLevel;
import com.example.tambahrizki.heathtracker.DataLevel;
import com.example.tambahrizki.heathtracker.MenuActivity;
import com.example.tambahrizki.heathtracker.R;

import java.util.ArrayList;

public class LevelActivity extends AppCompatActivity {
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    ArrayList<DataLevel> arraData = new ArrayList<>();

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        recyclerView = findViewById(R.id.recyclerViewLevel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arraData.add(new DataLevel("Day 1", "Jumping Jack", "15X", "Sit Up", "10X","Naik Turun Kursi","12X", "Push Up","4X", "Skipping", "30X"));
        arraData.add(new DataLevel("Day 2", "Bird Dog ", "10X", "Jumping Jack", "18X","Triceps Dips","5X", "Squats","12X", "Skipping", "30X"));
        arraData.add(new DataLevel("Day 3", "Jumping Jack", "20X", "Sit Up", "15X","Naik Turun Kursi","15X", "Push Up","10X", "Skipping", "30X"));
        arraData.add(new DataLevel("Day 4", "Bird Dog ", "15X", "Jumping Jack", "20X","Triceps Dips","10X", "Squats","18X", "Skipping", "35X"));
        arraData.add(new DataLevel("Day 5", "Jumping Jack", "20X", "Sit Up", "15X","Triceps Dips","5X", "Squats","12X", "Skipping", "40X"));


        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        AdapterListLevel adapter = new AdapterListLevel(this, arraData);
        recyclerView.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
