package com.example.tambahrizki.heathtracker;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;


/**
 * A simple {@link Fragment} subclass.
 */
public class IBMFragment extends Fragment {


    public IBMFragment() {
        // Required empty public constructor
    }

    EditText tinggi, berat;
    TextView hasil;
    Button buton;
    DbHelper dbHelper;
    protected Cursor cursor;
    int tgl;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ibm, container, false);
        buton = view.findViewById(R.id.hitungIBM);
        tinggi = view.findViewById(R.id.editText_tinggi_fragmen);
        berat = view.findViewById(R.id.editText_berat_fragmen);
        hasil = view.findViewById(R.id.textView_hasil);
        final CalendarDay cld = new CalendarDay();
        dbHelper = new DbHelper(getContext());

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase dbhit = dbHelper.getReadableDatabase();
                tgl = cld.getDay();
                cursor = dbhit.rawQuery("SELECT * FROM beratbadan;", null);
                if (tinggi.getText().toString().equalsIgnoreCase("")||berat.getText().toString().equalsIgnoreCase(""))
                {

                    Toast.makeText(getActivity(), "Data belum terisi dengan benar", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    final double tinggiibm = Double.valueOf(tinggi.getText().toString()) * 0.01;
                    final double tggibm = tinggiibm*tinggiibm;

                    final double beratIbm = Double.valueOf(berat.getText().toString());

                    final double hasilIbm = beratIbm/tggibm;;
                    if (hasilIbm<18.4)
                    {
                        hasil.setText("KURUS");
                    }
                    else if (hasilIbm>18.5 && hasilIbm <25.0)
                    {
                        hasil.setText("IDEAL");
                    }
                    else
                    {
                        hasil.setText("GEMUK");
                    }
                    AlertDialog.Builder alBuilder = new AlertDialog.Builder(getActivity());
                    alBuilder
                            .setMessage(hasil.getText().toString()+"\nApakah anda ingin menyimpan datanya?")
                            .setPositiveButton("Ya",
                                    new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog,
                                                            int which) {

                                            SQLiteDatabase db = dbHelper.getWritableDatabase();
                                            try {
                                                int jum = cursor.getCount()+1;
                                                int intBerat = (int) beratIbm;
                                                String sqlInsert = "insert into beratbadan(nomer, berat, tanggal) values("+jum+", "+intBerat+", "+tgl+");";
                                                db.execSQL(sqlInsert);
                                                Toast.makeText(getActivity(), "Data berhasil disimpan.", Toast.LENGTH_SHORT).show();
                                            }catch (SQLException e)
                                            {
                                                Toast.makeText(getActivity(), ""+e, Toast.LENGTH_LONG).show();
                                            }
                                            reset();
                                            dialog.cancel();
                                            // Write your code here for Yes
                                        }
                                    })
                            .setNegativeButton("Tidak",
                                    new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                            reset();
                                            dialog.cancel();
                                            // Write your code here for No
                                        }
                                    });
                    alBuilder.setCancelable(false);
                    alBuilder.show();

//                    Toast.makeText(getActivity(), ""+hasilIbm, Toast.LENGTH_SHORT).show();
//                    if (hasilIbm<18.4)
//                    {
//                        hasil.setText("KURUS");
//                    }
//                    else if (hasilIbm>18.5 && hasilIbm <25.0)
//                    {
//                        hasil.setText("IDEAL");
//                    }
//                    else
//                    {
//                        hasil.setText("GEMUK");
//                    }
                }


            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    public void reset(){
        tinggi.setText("");
        berat.setText("");
    }
}
