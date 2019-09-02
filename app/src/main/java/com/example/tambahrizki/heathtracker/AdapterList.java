package com.example.tambahrizki.heathtracker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tambahrizki.heathtracker.Workout.LevelActivity;

import java.util.ArrayList;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {
    Context context;
    ArrayList<DataListCustom> arrData;

    public AdapterList(Context context, ArrayList<DataListCustom> arrData) {
        this.context = context;
        this.arrData = arrData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
        ImageView gambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.txt_list);
            gambar = itemView.findViewById(R.id.img_list);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_list_recycler, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int posisi) {
        DataListCustom isi = arrData.get(posisi);

        viewHolder.judul.setText(isi.getJudul());
        viewHolder.gambar.setImageResource(isi.getGambar());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (posisi == 0)
                {
                    Intent inten = new Intent(context, LevelActivity.class);
                    context.startActivity(inten);
                }
                else if (posisi == 1)
                {
                    Intent inten = new Intent(context, LevelActivity.class);
                    context.startActivity(inten);
                }
                else if (posisi == 2)
                {
                    Intent inten = new Intent(context, LevelActivity.class);
                    context.startActivity(inten);
                }
                else if (posisi == 3)
                {
                    Intent inten = new Intent(context, LevelActivity.class);
                    context.startActivity(inten);
                }
                else if (posisi == 4)
                {
                    Intent inten = new Intent(context, LevelActivity.class);
                    context.startActivity(inten);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }


}
