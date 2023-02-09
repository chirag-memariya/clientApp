package com.example.clientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Toolbar
    Toolbar toolbar;

    LinearLayout walletBtn;
    LinearLayout bikeBtn;
//    ImageButton walletBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Toolbar
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //        setSupportActionBar(toolbar);

        //step -2
        if(getSupportActionBar()!=null){
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Custom_Toolbar_Name");
        }

        //set toolbar title
//        toolbar.setTitle("toolbarTitle");



//        addVehicleBtn=findViewById(R.id.addVehicle);
//        addVehicleBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(MainActivity.this,AddVehicle.class);
//                startActivity(i);
//            }
//        });





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
                Toast.makeText(MainActivity.this,"Bike selected",Toast.LENGTH_SHORT).show();
            }
        });
    }




//    private void setSupportActionBar(Toolbar toolbar) {
//    }
//    public void startLog(View view){
//        startActivity(new Intent(MainActivity.this, LogsActivity.class));
//    }
}