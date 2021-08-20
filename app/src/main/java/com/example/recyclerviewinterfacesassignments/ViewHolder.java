package com.example.recyclerviewinterfacesassignments;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    Interfaces listeners;
    TextView textView;
    Button buttonDlt;
    Button buttonEdit;
    public ViewHolder(@NonNull View itemView,Interfaces listeners) {
        super(itemView);
        this.listeners=listeners;
        initViews();
    }

    private void initViews() {
        textView=itemView.findViewById(R.id.tvText1);
        buttonDlt=itemView.findViewById(R.id.btnDlt);
        buttonEdit=itemView.findViewById(R.id.btnEdit);
    }
    void setData(ModelClass modelClass){
        textView.setText(modelClass.getTextView());
        buttonDlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listeners.deleteTask(getAdapterPosition());
            }
        });
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listeners.EditText(getAdapterPosition(),modelClass);
            }
        });
    }
}
