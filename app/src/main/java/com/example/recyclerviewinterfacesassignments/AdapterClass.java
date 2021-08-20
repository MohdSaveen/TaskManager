package com.example.recyclerviewinterfacesassignments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<ViewHolder>{

    ArrayList<ModelClass> task;

    Interfaces listeners;
    public AdapterClass(ArrayList<ModelClass> task,Interfaces listeners) {
        this.task=task;
        this.listeners=listeners;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view,listeners);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass modelClass=task.get(position);
      holder.setData(modelClass);
    }

    @Override
    public int getItemCount() {
        return task.size();
    }
}

