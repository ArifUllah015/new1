package com.example.myfinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScheduleRV extends RecyclerView.Adapter<ScheduleRV.ScheduleHolder>{

    OnItemClickListener onItemClickListener;
    Context context;
    List<ChildData> dataList;

    public ScheduleRV(Context contex, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.context = contex;
        dataList = new ArrayList<>();
    }

    public void setList(List<ChildData> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ScheduleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_view, parent, false);
        return new ScheduleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleHolder holder, int position) {
        ChildData childData = dataList.get(position);
        holder.date.setText(childData.getDate());
        holder.name.setText(childData.getAdd_childname());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ScheduleHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView date;

        public ScheduleHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTV);
            date = itemView.findViewById(R.id.birthDateTV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.getId(dataList.get(getAdapterPosition()).getChildDataID());
                }
            });
        }
    }
}

