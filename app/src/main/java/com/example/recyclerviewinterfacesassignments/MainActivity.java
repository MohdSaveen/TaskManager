package com.example.recyclerviewinterfacesassignments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Interfaces{
    RecyclerView recyclerView;
    CardView cardView;
    EditText editText;
    Button btnSave;
    Button btnAdd;
    ArrayList<ModelClass> task=new ArrayList<>();
    AdapterClass adapterClass;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.etText);
        btnSave=findViewById(R.id.btnSave);
        cardView=findViewById(R.id.cardView);
        btnAdd=findViewById(R.id.btnAdd);
        recyclerView=findViewById(R.id.recyclerview);
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ModelClass modelClass=new ModelClass("Set your task here");
                task.add(modelClass);
                adapterClass.notifyDataSetChanged();
            }
        });

        adapterClass=new AdapterClass(task,this);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterClass);
    }



    @Override
    public void deleteTask(int position) {
        task.remove(position);
        adapterClass.notifyDataSetChanged();

    }

    @Override
    public void EditText(int position, ModelClass modelClass) {
        cardView.setVisibility(View.VISIBLE);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView.setVisibility(View.GONE);
                ModelClass modelClass1=new ModelClass(editText.getText().toString());
                task.set(position,modelClass1);
                adapterClass.notifyDataSetChanged();

            }
        });
    }
}