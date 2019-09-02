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
import com.example.tambahrizki.heathtracker.MenuActivity;
import com.example.tambahrizki.heathtracker.R;
import com.example.tambahrizki.heathtracker.Workout.PlayActivity;

public class RivewActivity extends AppCompatActivity {

//    public RivewActivity(int array) {
//        this.array = array;
//    }

    protected Cursor cursor;
    int array;
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
    TextView jdl, gerakan;
    String gerak[]={"Mulailah dengan kaki bersatu dan lengan berada di sisi tubuh, lalu lompat dengan kaki terbuka dan tangan berada di atas kepala\n kembali ke posisi awal lalu lakukan gerakan selanjutnya. Latihan ini akan melatih seluruh tubuh dan bekerja semua otot besar Anda\n"
    ,"Langkah awal, tekuk lutut dengan bola kaki dan tumit ditempatkan rata dengan tanah.\n Letakkan tangan di atas bahu yang berlawanan, sehingga kedua lengan Anda bersilangan di atas dada, atau di belakang kepala seperti yang terlihat pada gambar diatas. Ini memungkinkan Anda mencapai titik kenaikan sentral.\n Kencangkan otot perut secara lembut dengan menarik pusar ke arah tulang belakang Anda.\n Dengan tetap menjaga agar tumit tetap di atas lantai dan jari-jari kaki rata dengan lantai, secara perlahan dan lembut angkat terlebih dahulu kepala, diikuti oleh tulang belikat Anda. Fokuskan mata Anda pada lutut Anda yang ditekuk, sambil mengontraksi otot-otot perut dengan lembut."
    ,"Berdiri di depan kursi, lalu naikan satu kaki anda terlebih dahulu lalu naikan kaki lainya ke kursi\n Latihan ini akan memperkuat otot kaki dan pantat\n"
    ,"Mulailah dengan berbaring di lantai yang di topang oleh lengan anda\n Saat anda mengangkat tubuh anda , tetaplah jaga agar badan anda tetap lurus.\n Latihan ini akan melatih dada, bahu, lengan bagian atas, punggung dan kaki.\n"
    ,"Mulai dengan tangan dan lutut anda menyentuh lantai, lalu kuatkan otot perut anda\n Angkat dan tarik ke belakang tangan kanan anda dan kaki kiri anda tahan selama 5 detik lalu lalukan dengan kaki dan tangan yang lain"};
    String gerak2[] = {"Mulai dengan tangan dan lutut anda menyentuh lantai, lalu kuatkan otot perut anda\n" +
            "Angkat dan tarik ke belakang tangan kanan anda dan kaki kiri anda tahan selama 5 detik lalu lalukan dengan kaki dan tangan yang lain\n"
            ,"Mulailah dengan kaki bersatu dan lengan berada di sisi tubuh, lalu lompat dengan kaki terbuka dan tangan berada di atas kepala\n" +
                    "kembali ke posisi awal lalu lakukan gerakan selanjutnya. Latihan ini akan melatih seluruh tubuh dan bekerja semua otot besar Anda\n"
            ,"Mulai dengan gerakan seperti anda ingin duduk di kursi sambil membelakangi kursi dan memegang kursi, lalu gerakan pinggul anda kebawah sambil memegang kursi\n" +
                    "Gerakan latihan ini secara perlahan agar anda dapat melatih lengan bagian atas anda\n"
            ,"Berdiri dan lebarkan kaki anda selebar bahu anda dan letakan lengan anda lurus kedepan, lalu mulailah gerakan pinggul anda hingga lutut anda lurus sejajar dengan pinggul anda\n" +
                    "Latihan ini bagus untuk melatih pinggul anda, paha anda dan tubuh bagian bawah anda.\n"
            ,"Mulai dengan tangan dan lutut anda menyentuh lantai, lalu kuatkan otot perut anda\n Angkat dan tarik ke belakang tangan kanan anda dan kaki kiri anda tahan selama 5 detik lalu lalukan dengan kaki dan tangan yang lain"
        };
    String gerak3[] = {"Mulailah dengan kaki bersatu dan lengan berada di sisi tubuh, lalu lompat dengan kaki terbuka dan tangan berada di atas kepala\n" +
            "kembali ke posisi awal lalu lakukan gerakan selanjutnya. Latihan ini akan melatih seluruh tubuh dan bekerja semua otot besar Anda\n"
            ,"Langkah awal, tekuk lutut dengan bola kaki dan tumit ditempatkan rata dengan tanah.\n" +
             "Letakkan tangan di atas bahu yang berlawanan, sehingga kedua lengan Anda bersilangan di atas dada, atau di belakang kepala seperti yang terlihat pada gambar diatas. Ini memungkinkan Anda mencapai titik kenaikan sentral.\n" +
             "Kencangkan otot perut secara lembut dengan menarik pusar ke arah tulang belakang Anda.\n" +
             "Dengan tetap menjaga agar tumit tetap di atas lantai dan jari-jari kaki rata dengan lantai, secara perlahan dan lembut angkat terlebih dahulu kepala, diikuti oleh tulang belikat Anda. Fokuskan mata Anda pada lutut Anda yang ditekuk, sambil mengontraksi otot-otot perut dengan lembut.\n,"
            ,"Berdiri di depan kursi, lalu naikan satu kaki anda terlebih dahulu lalu naikan kaki lainya ke kursi\n" +
                            "Latihan ini akan memperkuat otot kaki dan pantat\n"
            ,"Mulailah dengan berbaring di lantai yang di topang oleh lengan anda\n" +
                            "Saat anda mengangkat tubuh anda , tetaplah jaga agar badan anda tetap lurus.\n" +
                            "Latihan ini akan melatih dada, bahu, lengan bagian atas, punggung dan kaki.\n"
            ,"Mulailah dengan kaki bersatu dan lengan berada di sisi tubuh, lalu lompat dengan kaki terbuka dan tangan berada di atas kepala\n" +
                            "kembali ke posisi awal lalu lakukan gerakan selanjutnya. Latihan ini akan melatih seluruh tubuh dan bekerja semua otot besar Anda\n"
    };
    String gerak4[] = {
            "Mulai dengan tangan dan lutut anda menyentuh lantai, lalu kuatkan otot perut anda\n" +
                    "Angkat dan tarik ke belakang tangan kanan anda dan kaki kiri anda tahan selama 5 detik lalu lalukan dengan kaki dan tangan yang lain\n"
            ,"Mulailah dengan kaki bersatu dan lengan berada di sisi tubuh, lalu lompat dengan kaki terbuka dan tangan berada di atas kepala\n" +
            "kembali ke posisi awal lalu lakukan gerakan selanjutnya. Latihan ini akan melatih seluruh tubuh dan bekerja semua otot besar Anda\n"
            ,"Mulai dengan gerakan seperti anda ingin duduk di kursi sambil membelakangi kursi dan memegang kursi, lalu gerakan pinggul anda kebawah sambil memegang kursi\n" +
            "Gerakan latihan ini secara perlahan agar anda dapat melatih lengan bagian atas anda\n"
            ,"Berdiri dan lebarkan kaki anda selebar bahu anda dan letakan lengan anda lurus kedepan, lalu mulailah gerakan pinggul anda hingga lutut anda lurus sejajar dengan pinggul anda\n" +
            "Latihan ini bagus untuk melatih pinggul anda, paha anda dan tubuh bagian bawah anda.\n"
            ,"Mulailah dengan kaki bersatu dan lengan berada di sisi tubuh, lalu lompat dengan kaki terbuka dan tangan berada di atas kepala\n" +
            "kembali ke posisi awal lalu lakukan gerakan selanjutnya. Latihan ini akan melatih seluruh tubuh dan bekerja semua otot besar Anda\n"
    };
    String gerak5[]={
            "Mulailah dengan kaki bersatu dan lengan berada di sisi tubuh, lalu lompat dengan kaki terbuka dan tangan berada di atas kepala\n" +
                    "kembali ke posisi awal lalu lakukan gerakan selanjutnya. Latihan ini akan melatih seluruh tubuh dan bekerja semua otot besar Anda\n"
            ,"Langkah awal, tekuk lutut dengan bola kaki dan tumit ditempatkan rata dengan tanah.\n" +
            "Letakkan tangan di atas bahu yang berlawanan, sehingga kedua lengan Anda bersilangan di atas dada, atau di belakang kepala seperti yang terlihat pada gambar diatas. Ini memungkinkan Anda mencapai titik kenaikan sentral.\n" +
            "Kencangkan otot perut secara lembut dengan menarik pusar ke arah tulang belakang Anda.\n" +
            "Dengan tetap menjaga agar tumit tetap di atas lantai dan jari-jari kaki rata dengan lantai, secara perlahan dan lembut angkat terlebih dahulu kepala, diikuti oleh tulang belikat Anda. Fokuskan mata Anda pada lutut Anda yang ditekuk, sambil mengontraksi otot-otot perut dengan lembut.\n"
            ,"Mulai dengan gerakan seperti anda ingin duduk di kursi sambil membelakangi kursi dan memegang kursi, lalu gerakan pinggul anda kebawah sambil memegang kursi\n" +
            "Gerakan latihan ini secara perlahan agar anda dapat melatih lengan bagian atas anda\n"
            ,"Mulailah dengan kaki bersatu dan lengan berada di sisi tubuh, lalu lompat dengan kaki terbuka dan tangan berada di atas kepala\n" +
            "kembali ke posisi awal lalu lakukan gerakan selanjutnya. Latihan ini akan melatih seluruh tubuh dan bekerja semua otot besar Anda\n"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rivew);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gift = findViewById(R.id.imageView2);
        jdl = findViewById(R.id.textView7);
        gerakan = findViewById(R.id.text_Gerakan);


        DbHelper dbHelper = new DbHelper(getBaseContext());
        SQLiteDatabase dbGet = dbHelper.getReadableDatabase();
        cursor = dbGet.rawQuery("SELECT * FROM stepWorkout;", null);
        cursor.moveToFirst();

        array = cursor.getCount()-1;
        if (cursor.getInt(0)==1) {
            gift.setImageResource(gambar[array]);
            jdl.setText(judul[array]);
            gerakan.setText(gerak[array]);
        }else if (cursor.getInt(0)==2) {
            gift.setImageResource(gambar2[array]);
            jdl.setText(judul2[array]);
            gerakan.setText(gerak2[array]);
        }else if (cursor.getInt(0)==3) {
            gift.setImageResource(gambar3[array]);
            jdl.setText(judul3[array]);
            gerakan.setText(gerak3[array]);
        }else if (cursor.getInt(0)==4) {
            gift.setImageResource(gambar4[array]);
            jdl.setText(judul4[array]);
            gerakan.setText(gerak4[array]);
        }else if (cursor.getInt(0)==5) {
            gift.setImageResource(gambar5[array]);
            jdl.setText(judul5[array]);
            gerakan.setText(gerak5[array]);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            if (array>1){
                Intent intent = new Intent(this, PlayBeginActivity.class);
                startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void KlikTombol(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
}
