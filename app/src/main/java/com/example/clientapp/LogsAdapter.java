package com.example.clientapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class LogsAdapter extends RecyclerView.Adapter<LogsAdapter.ProfileViewHolder> {
    Context context;
    ArrayList<LogsModel> arrModel;
    public LogsAdapter(Context context, ArrayList<LogsModel> arrModel){
        this.context=context;
        this.arrModel=arrModel;
    }
    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.logs_row,parent,false);
        ProfileViewHolder viewHolder=new ProfileViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        holder.numberPlate.setText(arrModel.get(position).numberPlate);
        holder.outTime.setText(arrModel.get(position).outTime);
        holder.inTime.setText(arrModel.get(position).inTime);
        holder.fees.setText( "" +arrModel.get(position).fees);
    }

    @Override
    public int getItemCount() {
        return arrModel.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder{
        TextView numberPlate;
        TextView fees;
        TextView inTime;
        TextView outTime;
        public ProfileViewHolder(View itemView){
            super(itemView);
            numberPlate=itemView.findViewById(R.id.numberPlateTxtVew);
            inTime=itemView.findViewById(R.id.inTime);
            outTime=itemView.findViewById(R.id.outTime);
            fees=itemView.findViewById(R.id.parkingFee);
        }
    }

}
