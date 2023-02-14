package com.example.clientapp;

import static com.example.clientapp.VehicleNumber.vehicleNumbers;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.SnapshotHolder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LogsActivity extends AppCompatActivity {

    ArrayList<LogsModel> arrNumber =new ArrayList<LogsModel>();
    RecyclerView recyclerView;
    Spinner spinner;
    String numberPlate,current_id;
    String fees;
    String inTime,outTime;
    ArrayList<VehicleNumber> vehicleNumberArrayList=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinner=findViewById(R.id.selectCategoeryspinner);
        SpinnerData spinnerData=new SpinnerData();


//
//        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        arrNumber.add(new LogsModel("GJ34H3425","500", "Hello","Test"));
//        arrNumber.add(new LogsModel("BA93PA1948","500","500", "500"));
//        arrNumber.add(new LogsModel("BA93PA1934","500", "500", "500"));
//        arrNumber.add(new LogsModel("MH34H3425","500","500", "500"));
//        arrNumber.add(new LogsModel("BR34H3425","500","500", "500"));
//        arrNumber.add(new LogsModel("GJ34H3425","500","500", "500"));
//        arrNumber.add(new LogsModel("GJ34H3425","500", "500", "500"));
//        arrNumber.add(new LogsModel("GJ34H3425","500", "500", "500"));
//        arrNumber.add(new LogsModel("GJ34H3425","500","500", "500"));
//        arrNumber.add(new LogsModel("GJ34H3425","500", "500", "500"));

//        current_id = global_username.getUserid();


        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("VehicleHistory");
        Query checkUserDatabase = reference.orderByChild("transactionId");
        checkUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot snapshot1:snapshot.getChildren()) {
                    numberPlate = snapshot1.child("vehiclePlateNo").getValue(String.class);
                    inTime = snapshot1.child("inTime").getValue(String.class);
                    outTime = snapshot1.child("outTime").getValue(String.class);
                 //   int tmpFee = snapshot1.child("fee").getValue(Integer.class);
                //    fees=Integer.toString(tmpFee);
                    arrNumber.add(new LogsModel(numberPlate, "fees", inTime, outTime));
                   // System.out.println(numberPlate + "\n" + fees + "\n" + inTime + "\n" + outTime);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(LogsActivity.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });







        SystemClock.sleep(2000);
        SpinnerAdapter costomAdapter=new SpinnerAdapter(this,R.layout.costom_spinner_adapter,VehicleNumber.getVehicleNumbers());
        spinner.setAdapter(costomAdapter);

//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });

        LogsAdapter adapter=new LogsAdapter(this, arrNumber);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true; }
}