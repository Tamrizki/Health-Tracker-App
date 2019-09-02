package com.example.tambahrizki.heathtracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tambahrizki.heathtracker.Note.DataNote;

import java.util.ArrayList;

public class AdapterNoteDeskrispsi extends RecyclerView.Adapter<AdapterNoteDeskrispsi.ViewHolder> {
    ArrayList<DataNote>dataNotes;
    Context context;

    public AdapterNoteDeskrispsi(ArrayList<DataNote> dataNotes, Context context) {
        this.dataNotes = dataNotes;
        this.context = context;
    }

    public ArrayList<DataNote> getDataNotes() {
        return dataNotes;
    }

    public void setDataNotes(ArrayList<DataNote> dataNotes) {
        this.dataNotes = dataNotes;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul, deskripsi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        judul = itemView.findViewById(R.id.txt_judul_note);
        deskripsi = itemView.findViewById(R.id.txt_deskripsi_note);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_custom_note_conten, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {

        final DataNote data = dataNotes.get(i);
        viewHolder.judul.setText(data.getJudulArtikel());
        viewHolder.deskripsi.setText(data.getDeskripsi());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0){
                    Toast.makeText(context, ""+data.getJudulArtikel(), Toast.LENGTH_SHORT).show();
                }
                else if (i == 1){
                    Toast.makeText(context, ""+data.getJudulArtikel(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataNotes.size();
    }


}
