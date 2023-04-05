package com.example.clientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    //Toolbar
    Toolbar toolbar;
    TextView displau_user;
    LinearLayout walletBtn;
    String Current_user;
    LinearLayout bikeBtn,logBtn , showavalible;
//    ImageButton walletBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SpinnerData spinnerData=new SpinnerData();
       // VehicleNumber.initVehicleNumbers();


        // parking detail display
        showavalible = findViewById(R.id.ShowParkngSpace);
        showavalible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Parking_slot.class);
                startActivity(i);
            }
        });


        //Toolbar
        displau_user = findViewById(R.id.display_username);
        Current_user = global_username.getUsername();
        displau_user.setText("Hello "+ Current_user);
//        toolbar=(Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        //        setSupportActionBar(toolbar);

        //step -2
        if(getSupportActionBar()!=null){
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Client Application");

        }


        walletBtn=findViewById(R.id.wallet);
        walletBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent i=new Intent(MainActivity.this,walletActivity.class);
                Intent i=new Intent(MainActivity.this,Wallet_Upadate.class);
                startActivity(i);
            }
        });




        bikeBtn=findViewById(R.id.addVehicle);
        bikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),AddVehicle.class);
                startActivity(i);
               // Toast.makeText(MainActivity.this,"Bike selected",Toast.LENGTH_SHORT).show();
            }
        });


        logBtn=findViewById(R.id.transaction);
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext()," Wait We Are Fetching Data.",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,LogsActivity.class);
                startActivity(i);
            }
        });
    }

    public void profile_click(View view){

        Intent i = new Intent(getApplicationContext(), User_Profile.class);
        startActivity(i);
    }


}