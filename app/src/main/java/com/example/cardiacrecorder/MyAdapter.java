package com.example.cardiacrecorder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ModelViewHolder> {
    Context context;
    ArrayList<Model>modelArrayList=new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;

    public MyAdapter(Context context, int singledata, ArrayList<Model> modelArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public MyAdapter.ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.singledata,null);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ModelViewHolder holder, int position) {
        final Model model = modelArrayList.get(position);
        holder.txtdate.setText(model.getDate());
        holder.txttime.setText(model.getTime());
        holder.txtsystolic.setText(model.getSystolic());
        holder.txtdiastolic.setText(model.getDiastolic());
        holder.txtpulse.setText(model.getPulse());
        holder.txtextrimity.setText(model.getExtrimity());
        holder.txtposition.setText(model.getPosition());
        holder.txtcomment.setText(model.getComment());
        holder.txtverdict.setText(model.getVerdict());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ModelViewHolder extends RecyclerView.ViewHolder {
        TextView txtdate, txttime, txtsystolic, txtdiastolic, txtpulse, txtextrimity, txtposition, txtcomment, txtverdict;
        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            txtdate = (TextView)itemView.findViewById(R.id.txtdate);
            txttime = (TextView)itemView.findViewById(R.id.txttime);
            txtsystolic = (TextView)itemView.findViewById(R.id.txtsystolic);
            txtdiastolic = (TextView)itemView.findViewById(R.id.txtdiastolic);
            txtpulse = (TextView)itemView.findViewById(R.id.txtpulse);
            txtextrimity = (TextView)itemView.findViewById(R.id.txtextrimity);
            txtposition = (TextView)itemView.findViewById(R.id.txtposition);
            txtcomment = (TextView)itemView.findViewById(R.id.txtcomment);
            txtverdict = (TextView)itemView.findViewById(R.id.txtverdict);
        }
    }
}
