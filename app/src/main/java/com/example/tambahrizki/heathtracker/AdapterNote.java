package com.example.tambahrizki.heathtracker;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tambahrizki.heathtracker.Note.Nomer;
import com.example.tambahrizki.heathtracker.Note.TipsActivity;

import java.util.ArrayList;

public class AdapterNote extends RecyclerView.Adapter<AdapterNote.ViewHolder> {
    ArrayList<DataTubuh> dataTubuhs = new ArrayList<>();
    ArrayList<Nomer> no;
    Nomer nomer;
    Context context;
//    DbHelper dbHelper;
//    protected Cursor cursor;
    public AdapterNote(ArrayList<DataTubuh> dataTubuhs, Context context) {
        this.dataTubuhs = dataTubuhs;
        this.context = context;
    }

    public ArrayList<DataTubuh> getDataTubuhs() {
        return dataTubuhs;
    }

    public void setDataTubuhs(ArrayList<DataTubuh> dataTubuhs) {
        this.dataTubuhs = dataTubuhs;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tubuh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tubuh = itemView.findViewById(R.id.tubuh);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_custom_note, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
//        dbHelper = new DbHelper(getContext());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final DataTubuh data = dataTubuhs.get(i);


        viewHolder.tubuh.setText(data.getTubuh());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dbHelper = new DbHelper(getContext());
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (i == 0){
//                    String sqlU = "update Nomer set nomer = 1 where id = 1;";
//                    db.execSQL(sqlU);
                    nomer = new Nomer(1);
                    Intent intent = new Intent(context, TipsActivity.class);
                    intent.putExtra("nomer", 1);
                    context.startActivity(intent);

                }
                else if (i == 1){
//                    String sqlU = "update Nomer set nomer = 2 where id = 1;";
//                    db.execSQL(sqlU);
                    Nomer nomer = new Nomer(2);
                    Intent intent = new Intent(context, TipsActivity.class);
                    intent.putExtra("nomer", 2);
                    context.startActivity(intent);
                }
                else if (i == 2){
//                    String sqlU = "update Nomer set nomer = 3 where id = 1;";
//                    db.execSQL(sqlU);
                    Nomer nomer = new Nomer(3);
                      Intent intent = new Intent(context, TipsActivity.class);
                    intent.putExtra("nomer", 3);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataTubuhs.size();
    }


}
