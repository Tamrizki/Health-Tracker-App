package com.example.tambahrizki.heathtracker.Workout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tambahrizki.heathtracker.DbHelper;
import com.example.tambahrizki.heathtracker.R;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {



    CountDownTimer timer;
    TextView waktu;
    final long startTime = 10*1000;
    long interval = 1*1000;
    String go;
    ImageView img;
    protected Cursor cursor;
    int gambar []={R.drawable.jumping,R.drawable.sit_up,R.drawable.naik_kursi,R.drawable.pushup,R.drawable.skipping};
    int gambar2 []={R.drawable.bird_dog,R.drawable.jumping,R.drawable.trisep,R.drawable.squad,R.drawable.skipping};
    int gambar3 []={R.drawable.jumping,R.drawable.sit_up,R.drawable.naik_kursi,R.drawable.pushup,R.drawable.skipping};
    int gambar4 []={R.drawable.bird_dog,R.drawable.jumping,R.drawable.trisep,R.drawable.squad,R.drawable.skipping};
    int gambar5 []={R.drawable.jumping,R.drawable.sit_up,R.drawable.trisep,R.drawable.squad,R.drawable.skipping};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        waktu =  findViewById(R.id.waktu);
        Button btn = findViewById(R.id.lewat);
        img = findViewById(R.id.imageView_gift);

        DbHelper dbHelper = new DbHelper(getBaseContext());
        SQLiteDatabase dbGet = dbHelper.getReadableDatabase();
        cursor = dbGet.rawQuery("SELECT * FROM stepWorkout;", null);
        int array = cursor.getCount()-1;
        cursor.moveToFirst();
        if (cursor.getInt(0)==1){
            img.setImageResource(gambar[array]);
        }
        else if (cursor.getInt(0)==2){
            img.setImageResource(gambar2[array]);
        }
        else if (cursor.getInt(0)==3){
            img.setImageResource(gambar3[array]);
        }
        else if (cursor.getInt(0)==4){
            img.setImageResource(gambar4[array]);
        }
        else if (cursor.getInt(0)==5){
            img.setImageResource(gambar5[array]);
        }



        timer = new CountDownTimer(startTime, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                waktu.setText(""+millisUntilFinished/1000);
            }
            @Override
            public void onFinish() {
                waktu.setText("Mulai");
                Intent intent = new Intent(PlayActivity.this, PlayBeginActivity.class);
                startActivity(intent);
            }
        };
        timer.start();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(this, RivewActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void Lewat(View view) {
        Intent intent = new Intent(this, PlayBeginActivity.class);
        timer.cancel();
        startActivity(intent);
    }
}
