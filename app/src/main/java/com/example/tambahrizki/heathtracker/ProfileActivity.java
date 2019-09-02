package com.example.tambahrizki.heathtracker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    TextView nama, jk, email, usia, tinggi, berat;
    ImageView imgprofile;
    protected Cursor cursor;

    int profile [] = {R.drawable.profile, R.drawable.profile_female};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nama = findViewById(R.id.textView_nama);
        jk = findViewById(R.id.textView_nama_lengkap);
        email = findViewById(R.id.textView_email);
        usia = findViewById(R.id.textView_usia);
        tinggi = findViewById(R.id.textView_tinggi);
        berat = findViewById(R.id.textView_berat);
        imgprofile = findViewById(R.id.imageView7);

        DbHelper dbHelper = new DbHelper(getBaseContext());
        SQLiteDatabase dbGet = dbHelper.getReadableDatabase();
        cursor = dbGet.rawQuery("SELECT * FROM biodata;", null);
        cursor.moveToFirst();

        email.setText(cursor.getString(0));
        nama.setText(cursor.getString(1));
        jk.setText(cursor.getString(2));
        String susia, sberat, stinggi;
        susia = String.valueOf(cursor.getInt(3));
        sberat = String.valueOf(cursor.getInt(4));
        stinggi = String.valueOf(cursor.getInt(5));
        usia.setText(susia+" th");
        berat.setText(sberat+" kg");
        tinggi.setText(stinggi+" cm");
        if (cursor.getString(2).equalsIgnoreCase("Laki-laki"))
        {
            imgprofile.setImageResource(profile[0]);
        }
        else
        {
            imgprofile.setImageResource(profile[1]);
        }
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
