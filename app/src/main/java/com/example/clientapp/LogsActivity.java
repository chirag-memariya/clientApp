package com.example.clientapp;

import static com.example.clientapp.VehicleNumber.vehicleNumbers;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.Spinner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LogsActivity extends AppCompatActivity {

    ArrayList<LogsModel> arrNumber =new ArrayList<LogsModel>();
    RecyclerView recyclerView;
    Spinner spinner;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinner=findViewById(R.id.selectCategoeryspinner);


        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        arrNumber.add(new LogsModel("GJ34H3425",10.00f, LocalDateTime.now(),LocalDateTime.now()));
        arrNumber.add(new LogsModel("BA93PA1948",10.00f, LocalDateTime.now(),LocalDateTime.now()));
        arrNumber.add(new LogsModel("BA93PA1934",10.00f, LocalDateTime.now(),LocalDateTime.now()));
        arrNumber.add(new LogsModel("MH34H3425",10.00f, LocalDateTime.now(),LocalDateTime.now()));
        arrNumber.add(new LogsModel("BR34H3425",10.00f, LocalDateTime.now(),LocalDateTime.now()));
        arrNumber.add(new LogsModel("GJ34H3425",10.00f, LocalDateTime.now(),LocalDateTime.now()));
        arrNumber.add(new LogsModel("GJ34H3425",10.00f, LocalDateTime.now(),LocalDateTime.now()));
        arrNumber.add(new LogsModel("GJ34H3425",10.00f, LocalDateTime.now(),LocalDateTime.now()));
        arrNumber.add(new LogsModel("GJ34H3425",10.00f, LocalDateTime.now(),LocalDateTime.now()));
        arrNumber.add(new LogsModel("GJ34H3425",10.00f, LocalDateTime.now(),LocalDateTime.now()));

        LogsAdapter adapter=new LogsAdapter(this, arrNumber);
        recyclerView.setAdapter(adapter);


        SpinnerAdapter costomAdapter=new SpinnerAdapter(this,R.layout.costom_spinner_adapter,VehicleNumber.getVehicleNumbers());
        spinner.setAdapter(costomAdapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true; }
}