package com.example.tambahrizki.heathtracker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tambahrizki.heathtracker.Note.NoteFragment;
import com.example.tambahrizki.heathtracker.Workout.WorkOutFragment;

public class AdapterPage extends FragmentPagerAdapter {
    private String [] page = {"Satu", "Dua", "Tiga", "Empat", "Lima", "Enam"};

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return page[position];
//    }

    public AdapterPage(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
       Fragment fr = null;
       switch (i){
           case 0: fr = new IBMFragment(); break;
           case 1: fr = new PuasaFragment(); break;
           case 2: fr = new WorkOutFragment(); break;
           case 3: fr = new KalenderFragment(); break;
           case 4: fr = new GrafikFragment(); break;
           case 5: fr = new NoteFragment(); break;
       }
        return fr;
    }

    @Override
    public int getCount() {
        return page.length;
    }
}
