package com.example.tambahrizki.heathtracker;


import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class KalenderFragment extends Fragment {


    public KalenderFragment() {
        // Required empty public constructor
    }
    MaterialCalendarView mCV;
    TextView txtTanggal, txtBerat;
    int tgl, bln, thn;
    String bulan;
    DbHelper dbHelper;
    protected Cursor cursor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmen = inflater.inflate(R.layout.fragment_kalender, container, false);
        mCV = fragmen.findViewById(R.id.calendarView);
        txtTanggal = fragmen.findViewById(R.id.txt_tanggal);
        txtBerat = fragmen.findViewById(R.id.txt_Berat);
        CalendarDay cld = new CalendarDay();
        tgl = cld.getDay();
        bln = cld.getMonth();
        thn = cld.getYear();

        dbHelper = new DbHelper(getContext());

        SQLiteDatabase dbhit = dbHelper.getReadableDatabase();
        try {
            cursor = dbhit.rawQuery("SELECT * FROM beratbadan where tanggal = "+tgl+";", null);
            String tampil = "";
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                tampil = String.valueOf(cursor.getInt(1)) + " Kg \n";
            }
                cursor.close();
                txtBerat.setText(tampil);
        }catch (SQLException e)
        {
            txtBerat.setText("-");
        }
//        cursor = dbhit.rawQuery("SELECT * FROM beratbadan where tanggal = "+tgl+";", null);
//        String tampil = "";
//        if (cursor.getCount()==0)
//        {
//            txtBerat.setText("-");
//        }else {
//            for (int i = 0; i < cursor.getCount(); i++) {
//                cursor.moveToPosition(i);
//                tampil = String.valueOf(cursor.getInt(1)) + " Kg \n";
//            }
//            cursor.close();
//            txtBerat.setText(tampil);
//        }

        switch (bln)
        {
            case 1: bulan = "Januari";break;
            case 2: bulan = "Februari";break;
            case 3: bulan = "Maret";break;
            case 4: bulan = "April";break;
            case 5: bulan = "Mei";break;
            case 6: bulan = "Juni";break;
            case 7: bulan = "Juli";break;
            case 8: bulan = "Agustus";break;
            case 9: bulan = "September";break;
            case 10: bulan = "Oktober";break;
            case 11: bulan = "November";break;
            case 12: bulan = "Desember";break;
        }
        txtTanggal.setText(String.valueOf(tgl)+", "+bulan+" "+String.valueOf(thn));
        mCV.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override

            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                switch (date.getMonth())
                {
                    case 1: bulan = "Januari";break;
                    case 2: bulan = "Februari";break;
                    case 3: bulan = "Maret";break;
                    case 4: bulan = "April";break;
                    case 5: bulan = "Mei";break;
                    case 6: bulan = "Juni";break;
                    case 7: bulan = "Juli";break;
                    case 8: bulan = "Agustus";break;
                    case 9: bulan = "September";break;
                    case 10: bulan = "Oktober";break;
                    case 11: bulan = "November";break;
                    case 12: bulan = "Desember";break;
                }
                txtTanggal.setText(date.getDay()+", "+bulan+" "+date.getYear());
                String tampil = "";
                try {
                    SQLiteDatabase dbhit = dbHelper.getReadableDatabase();
                    cursor = dbhit.rawQuery("SELECT * FROM beratbadan where tanggal = "+date.getDay()+";", null);
                    if (cursor.getCount()==0)
                    {
                        txtBerat.setText("-");
                    }
                    else {
                            cursor.moveToPosition(cursor.getCount()-1);
                            tampil = String.valueOf(cursor.getInt(1)) + " Kg \n";
                        cursor.close();
                        txtBerat.setText(tampil);
                    }
                }catch (SQLException e)
                {
                    Toast.makeText(getActivity(), "kosong", Toast.LENGTH_SHORT).show();
                    txtBerat.setText("-");
                }



            }
        });

        return fragmen;
    }

}
