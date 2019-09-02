package com.example.tambahrizki.heathtracker.Workout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tambahrizki.heathtracker.DbHelper;
import com.example.tambahrizki.heathtracker.R;

public class PlayBeginActivity extends AppCompatActivity {

    DbHelper dbHelper;
    protected Cursor cursor;
    ImageView gift;
    int gambar []={R.drawable.jumping,R.drawable.sit_up,R.drawable.naik_kursi,R.drawable.pushup,R.drawable.skipping};
    int gambar2 []={R.drawable.bird_dog,R.drawable.jumping,R.drawable.trisep,R.drawable.squad,R.drawable.skipping};
    int gambar3 []={R.drawable.jumping,R.drawable.sit_up,R.drawable.naik_kursi,R.drawable.pushup,R.drawable.skipping};
    int gambar4 []={R.drawable.bird_dog,R.drawable.jumping,R.drawable.trisep,R.drawable.squad,R.drawable.skipping};
    int gambar5 []={R.drawable.jumping,R.drawable.sit_up,R.drawable.trisep,R.drawable.squad,R.drawable.skipping};
    String judul []= {"Jumping Jack","Sit Up","Naik Turun Kursi","Push Up","Skipping"};
    String judul2 [] = {"Bird Dog ","Jumping Jack","Triceps Dips","Squats","Skipping"};
    String judul3 []={"Jumping Jack", "Sit Up", "Naik Turun Kursi", "Push Up","Skipping"};
    String judul4 []={"Bird Dog ","Jumping Jack","Triceps Dips","Squats","Skipping"};
    String judul5 []={"Jumping Jack","Sit Up","Triceps Dips","Squats","Skipping"};
    TextView jdl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_begin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        jdl = findViewById(R.id.textView9);
        gift = findViewById(R.id.imageView6);

        dbHelper = new DbHelper(getBaseContext());
        SQLiteDatabase dbGet = dbHelper.getReadableDatabase();
        cursor = dbGet.rawQuery("SELECT * FROM stepWorkout;", null);
        int img = cursor.getCount()-1;
        cursor.moveToFirst();
        if (cursor.getInt(0)==1){
            gift.setImageResource(gambar[img]);
            jdl.setText(judul[img]);
        }else if (cursor.getInt(0)==2){
            gift.setImageResource(gambar2[img]);
            jdl.setText(judul2[img]);
        }else if (cursor.getInt(0)==3){
            gift.setImageResource(gambar3[img]);
            jdl.setText(judul3[img]);
        }else if (cursor.getInt(0)==4){
            gift.setImageResource(gambar4[img]);
            jdl.setText(judul4[img]);
        }else if (cursor.getInt(0)==5){
            gift.setImageResource(gambar5[img]);
            jdl.setText(judul5[img]);
        }



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(this, RivewActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void KlikDone(View view) {

        int array = cursor.getCount()+cursor.getInt(0);

        dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "insert into stepWorkout(jumlah) values("+array+")";
        db.execSQL(sql);

        if (array>5){
            Intent intent = new Intent(this, CompleteActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, RivewActivity.class);
            startActivity(intent);
        }

    }
}
