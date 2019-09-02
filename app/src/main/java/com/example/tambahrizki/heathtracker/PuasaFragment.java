package com.example.tambahrizki.heathtracker;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class PuasaFragment extends Fragment {


    public PuasaFragment() {
        // Required empty public constructor
    }
    Button btn;
    ConstraintLayout backgroundNotif;
    FrameLayout backgroundtampilan;
    int klik = 0;

    CountDownTimer timer;
    boolean timerStart = false;
    TextView waktu;
    long startTime = 21600*1000;
    long interval = 1*1000;
    String go;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragmen = inflater.inflate(R.layout.fragment_puasa, container, false);
        backgroundNotif = fragmen.findViewById(R.id.notif_puasa);
        backgroundNotif.setVisibility(View.GONE);
        btn = fragmen.findViewById(R.id.button_Mulai);
        backgroundtampilan = fragmen.findViewById(R.id.frameLayout_puasa);

        waktu =  fragmen.findViewById(R.id.waktu);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                klik = klik+1;
                if (klik%2==1)
                {
                    timer = new CountDownTimer(startTime, interval) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            startTime = millisUntilFinished;
//                            waktu.setText(""+millisUntilFinished/1000);
                            updateTime();
                        }
                        @Override
                        public void onFinish() {
                            waktu.setText("Waktunya Makan");
                        }
                    };
                    timer.start();
                    backgroundtampilan.setVisibility(View.GONE);
                    backgroundNotif.setVisibility(View.VISIBLE);
                    btn.setText("Restart");
                }
                else
                {
                    timer.cancel();
                    backgroundtampilan.setVisibility(View.VISIBLE);
                    backgroundNotif.setVisibility(View.GONE);
                    btn.setText("Mulai");
                }
            }
        });

        return fragmen;
    }

    public void updateTime(){
        int minutes = (int) startTime/60000;
        int second = (int) startTime % 60000 /1000;

        String formatWaktu = "";

        if (second<10)
        {
            formatWaktu += "0";
        }
        formatWaktu = ""+minutes;
        formatWaktu += ":";

        formatWaktu += second;

        waktu.setText(formatWaktu);

    }

}
