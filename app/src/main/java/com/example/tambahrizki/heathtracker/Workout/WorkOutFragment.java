package com.example.tambahrizki.heathtracker.Workout;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tambahrizki.heathtracker.AdapterList;
import com.example.tambahrizki.heathtracker.DataListCustom;
import com.example.tambahrizki.heathtracker.DbHelper;
import com.example.tambahrizki.heathtracker.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkOutFragment extends Fragment {


    public WorkOutFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<DataListCustom> array = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmen = inflater.inflate(R.layout.fragment_work_out, container, false);
        // Inflate the layout for this fragment
        recyclerView = fragmen.findViewById(R.id.recyclerView);
        array.clear();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        array.add(new DataListCustom(R.drawable.menu_body,"Full Body Workout" ));
        array.add(new DataListCustom(R.drawable.menu_fit,"Abs Workout" ));
        array.add(new DataListCustom(R.drawable.menu_butt,"Butt Workout" ));
        array.add(new DataListCustom(R.drawable.menu_muscle,"Arm Workout" ));
        array.add(new DataListCustom(R.drawable.menu_leg,"Leg Workout" ));
        AdapterList adapterList = new AdapterList(getActivity(), array);
        recyclerView.setAdapter(adapterList);

        return fragmen;
    }

}
