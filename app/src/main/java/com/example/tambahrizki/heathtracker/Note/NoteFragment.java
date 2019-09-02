package com.example.tambahrizki.heathtracker.Note;


import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tambahrizki.heathtracker.AdapterNote;
import com.example.tambahrizki.heathtracker.DataTubuh;
import com.example.tambahrizki.heathtracker.DbHelper;
import com.example.tambahrizki.heathtracker.R;

import java.util.ArrayList;


public class NoteFragment extends Fragment {


    public NoteFragment() {
        // Required empty public constructor
    }
DbHelper dbHelper;
   RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<DataTubuh> array = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmen = inflater.inflate(R.layout.fragment_note, container, false);
        // Inflate the layout for this fragment
        recyclerView = fragmen.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        array.clear();
        array.add(new DataTubuh("GEMUK" ));
        array.add(new DataTubuh("IDEAL" ));
        array.add(new DataTubuh("KURUS" ));
        AdapterNote adapterNote = new AdapterNote(array, getActivity());
        recyclerView.setAdapter(adapterNote);
//        dbHelper = new DbHelper(getContext());
//
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        try {
//            String sql = "insert into nomer(idNo, nmr) values( 1, 1);";
//            db.execSQL(sql);
//        }catch (SQLException e)
//        {
//            Toast.makeText(getActivity(), e+"di fragmant"+e, Toast.LENGTH_LONG).show();
//        }


       return fragmen;
    }
}
