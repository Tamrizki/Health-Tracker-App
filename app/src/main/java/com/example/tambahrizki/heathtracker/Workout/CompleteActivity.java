package com.example.tambahrizki.heathtracker.Workout;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.tambahrizki.heathtracker.DbHelper;
import com.example.tambahrizki.heathtracker.MenuActivity;
import com.example.tambahrizki.heathtracker.R;

public class CompleteActivity extends AppCompatActivity {
    ImageButton done;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        done = findViewById(R.id.selesai);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DbHelper(getBaseContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql = "delete from stepWorkout;";
                db.execSQL(sql);

                Intent intent = new Intent(CompleteActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }


}
