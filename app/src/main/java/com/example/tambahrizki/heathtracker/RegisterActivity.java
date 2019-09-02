package com.example.tambahrizki.heathtracker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;

public class RegisterActivity extends AppCompatActivity {

    EditText email, username, usia, berat, tinggi;
    String semail, susername;
    int iusia, iberat, itinggi;
    Button btn;
    String jeniskelamin;
    RadioGroup radio;
    protected Cursor cursor;
    int tgl;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn = findViewById(R.id.buttonMasuk);
        email = findViewById(R.id.txt_email);
        username = findViewById(R.id.txt_nama);
        usia = findViewById(R.id.txt_Password);
        berat = findViewById(R.id.txt_berat);
        tinggi = findViewById(R.id.txt_Tinggi);
        radio = findViewById(R.id.rdgrupJK);
        dbHelper = new DbHelper(this);
        final CalendarDay cld = new CalendarDay();


        SQLiteDatabase dbGet = dbHelper.getReadableDatabase();
        cursor = dbGet.rawQuery("SELECT * FROM biodata", null);

        if (cursor.getCount()>0)
        {
            Intent intent = new Intent(RegisterActivity.this,MenuActivity.class );
            startActivity(intent);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equalsIgnoreCase("") || username.getText().toString().equalsIgnoreCase("") || usia.getText().toString().equalsIgnoreCase("")
                        || tinggi.getText().toString().equalsIgnoreCase("") || berat.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(RegisterActivity.this, "Form Harus terisi dengan benar!!", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                        semail = email.getText().toString();
                        susername = username.getText().toString();
                        iusia = Integer.parseInt(usia.getText().toString());
                        iberat = Integer.parseInt(berat.getText().toString());
                        itinggi = Integer.parseInt(tinggi.getText().toString());
                        int id = radio.getCheckedRadioButtonId();
                        switch (id){
                            case R.id.rdLaki:
                                jeniskelamin = "Laki-laki";break;
                            case R.id.rdCewe:
                                jeniskelamin = "Perempuan";break;
                        }
                        try {
                            SQLiteDatabase db = dbHelper.getWritableDatabase();
                            tgl = cld.getDay();
                            String sql = "insert into biodata(email, username, jeniskelamin, usia, berat, tinggi) values('"+
                                    semail+"', '"+
                                    susername+"', '"+
                                    jeniskelamin+"', "+
                                    iusia+", "+
                                    iberat+", "+
                                    itinggi+" )";

                            db.execSQL(sql);

                            String sqlInsert = "insert into beratbadan(nomer, berat, tanggal) values(1, "+iberat+", "+tgl+");";
                            db.execSQL(sqlInsert);

                            Intent intent = new Intent(RegisterActivity.this,MenuActivity.class );
                            startActivity(intent);
//                  Toast.makeText(RegisterActivity.this, "Input Data berhasil"+cursor.getCount(), Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception a)
                        {
                            Toast.makeText(RegisterActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
        });
    }
    public void tampil(){
        SQLiteDatabase dbGet = dbHelper.getReadableDatabase();
        cursor = dbGet.rawQuery("SELECT * FROM biodata", null);
    }

    public void KlikMasuk(View view) {

    }
}
