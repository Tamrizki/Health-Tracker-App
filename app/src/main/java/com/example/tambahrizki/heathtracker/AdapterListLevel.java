package com.example.tambahrizki.heathtracker;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tambahrizki.heathtracker.Workout.RivewActivity;

import java.util.ArrayList;

public class AdapterListLevel extends RecyclerView.Adapter<AdapterListLevel.ViewHolder> {

    Context context;
    ArrayList<DataLevel> dataLevels = new ArrayList<>();
    private DbHelper dbHelper;

    public AdapterListLevel(Context context, ArrayList<DataLevel> dataLevels) {
        this.context = context;
        this.dataLevels = dataLevels;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<DataLevel> getDataLevels() {
        return dataLevels;
    }

    public void setDataLevels(ArrayList<DataLevel> dataLevels) {
        this.dataLevels = dataLevels;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul_Day, ger1, ger2, ger3, ger4, ger5, jum1, jum2, jum3, jum4, jum5;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul_Day = itemView.findViewById(R.id.txt_workoutlevel);
            ger1 = itemView.findViewById(R.id.txt_text1);
            ger2 = itemView.findViewById(R.id.txt_text2);
            ger3 = itemView.findViewById(R.id.txt_text3);
            ger4 = itemView.findViewById(R.id.txt_text4);
            ger5 = itemView.findViewById(R.id.txt_text5);
            jum1 = itemView.findViewById(R.id.txt_text1_level);
            jum2 = itemView.findViewById(R.id.txt_text1_leve2);
            jum3 = itemView.findViewById(R.id.txt_text1_leve3);
            jum4 = itemView.findViewById(R.id.txt_text1_leve4);
            jum5 = itemView.findViewById(R.id.txt_text1_leve5);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_custom_level, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        DataLevel data = dataLevels.get(i);
        viewHolder.judul_Day.setText(data.getJudul_Day());
        viewHolder.ger1.setText(data.getGerakan1());
        viewHolder.ger2.setText(data.getGerakan2());
        viewHolder.ger3.setText(data.getGerakan3());
        viewHolder.ger4.setText(data.getGerakan4());
        viewHolder.ger5.setText(data.getGerakan5());
        viewHolder.jum1.setText(data.getJumger1());
        viewHolder.jum2.setText(data.getJumger2());
        viewHolder.jum3.setText(data.getJumger3());
        viewHolder.jum4.setText(data.getJumger4());
        viewHolder.jum5.setText(data.getJumger5());
        dbHelper = new DbHelper(context);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (i == 0){
                    try{
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        String sqla = "insert into stepWorkout(jumlah) values(1);";
                        db.execSQL(sqla);
                        Intent intent = new Intent(context, RivewActivity.class);
                        context.startActivity(intent);

                    }catch (SQLException e){
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                else if (i == 1){

                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    String sqla = "insert into stepWorkout(jumlah) values(2);";
                    db.execSQL(sqla);
                    Intent intent = new Intent(context, RivewActivity.class);
                    context.startActivity(intent);
                }
                else if (i == 2){

                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    String sqla = "insert into stepWorkout(jumlah) values(3);";
                    db.execSQL(sqla);
                    Intent intent = new Intent(context, RivewActivity.class);
                    context.startActivity(intent);
                }
                else if (i == 3){

                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    String sqla = "insert into stepWorkout(jumlah) values(4);";
                    db.execSQL(sqla);
                    Intent intent = new Intent(context, RivewActivity.class);
                    context.startActivity(intent);
                }
                else if (i == 4){

                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    String sqla = "insert into stepWorkout(jumlah) values(5);";
                    db.execSQL(sqla);
                    Intent intent = new Intent(context, RivewActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataLevels.size();
    }


}
