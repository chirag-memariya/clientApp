package com.example.clientapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_balance extends AppCompatActivity {
    EditText editTextAddAmount;
    Button Continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance);


        editTextAddAmount=findViewById(R.id.editTextAddAmount);
//        Intent intent=getIntent();

        String str=editTextAddAmount.getText().toString();
//        int added=Integer.parseInt(str);
//        intent.putExtra("added",added);
//        setResult(RESULT_OK,intent);

        Continue=findViewById(R.id.payBtn);
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(add_balance.this, str+"money added", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}