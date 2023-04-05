package com.example.clientapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Parking_slot extends AppCompatActivity {

    TextView textView;
    static  String[] gridViewValue = new String[40];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_slot);

        GridView gridView=findViewById(R.id.gridView);

        for(int i=1;i<=40;i++){
            gridViewValue[i-1]=i+"";
        }








        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.parking_adapter,gridViewValue);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                System.out.println(position);
                System.out.println(id);
                gridView.getChildAt(position).setBackgroundColor(Color.GRAY);
            }
        });
    }
}