package com.example.clientapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class add_balance extends AppCompatActivity {
    EditText editTextAddAmount;
    Button Continue;
    TextView Tbalance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance);


        editTextAddAmount=findViewById(R.id.editTextAddAmount);
        Tbalance=findViewById(R.id.Tbalance);
        Continue=findViewById(R.id.payBtn);

/*
//        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
////        DatabaseReference ref = rootRef.child("Hospital").child("QCH");
//        DatabaseReference ref = rootRef.child("programing knowladge");
//        ValueEventListener valueEventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String customerBalance = dataSnapshot.child("Balance").getValue(String.class);
//                Toast.makeText(add_balance.this, "Customer balance "+customerBalance, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        };
//        ref.addListenerForSingleValueEvent(valueEventListener);


        // below line is used to get
        // reference for our database.
  //      databaseReference = firebaseDatabase.getReference("Balance");

//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("programing knowladge");
//        Query checkUserDatabase = reference.orderByChild("Name").equalTo("Chirag");
//
/*        checkUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Query checkUserDatabase = reference.orderByChild("Name").equalTo("Chirag");
                    Toast.makeText(add_balance.this, " "+ current_balance, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        */

        //firebase
        FirebaseDatabase firebaseDatabase;
        firebaseDatabase = FirebaseDatabase.getInstance();


        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference().child("programing knowladge");

        int arr[]=new int[2];
        setData(databaseReference,Tbalance,arr);
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added_amoount=editTextAddAmount.getText().toString();
                int editAmount=Integer.parseInt(added_amoount);
                if(added_amoount.isEmpty()){
                    Toast.makeText(add_balance.this, "Please Enter a Amount!!", Toast.LENGTH_SHORT).show();
                }else{
                    //set data
                    /*
                    DatabaseReference databaseReference1=FirebaseDatabase.getInstance().getReference().child("programing knowladge");
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int value = snapshot.child("amt").getValue(Integer.class);  //-->>>> retrieved from  database

                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getApplicationContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();
                        }
                    }); */
                    FirebaseDatabase.getInstance().getReference("programing knowladge").child("amt").setValue(arr[0]+editAmount);
                    Toast.makeText(add_balance.this, "Rs. "+added_amoount+" added", Toast.LENGTH_SHORT).show();
                    finish();


                }
            }
        });

/*
        //add database balance

//        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference().child("Languages");



        /// //////// abhi code


//        int total_balance=50;
////        total_balance=setData(databaseReference,Tbalance);
//        // initializing our object class variable.
//
//        int finalTotal_balance = total_balance;
//        Continue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
         //       String added_amoount_str=editTextAddAmount.getText().toString();
           //     int added_amoount=Integer.parseInt(added_amoount_str);

            //    if(added_amoount_str.isEmpty()){
             //       Toast.makeText(add_balance.this, "Please Enter a Amount!!", Toast.LENGTH_SHORT).show();
              //  }else{

               //     FirebaseDatabase.getInstance().getReference("programing knowladge").child("Balance").setValue( (finalTotal_balance + added_amoount));
//                    Toast.makeText(add_balance.this, "Rs. "+added_amoount+" added", Toast.LENGTH_SHORT).show();
//                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("programing knowladge");
//                    Query checkUserDatabase = reference.orderByChild("Name").equalTo("Chirag");
//
//                    checkUserDatabase.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            String namefromdb = "";
//
//                            for(DataSnapshot dataSnapshot1:snapshot.getChildren())
//                            {     namefromdb = dataSnapshot1.child("Email").getValue(String.class);
//                                Toast.makeText(add_balance.this, " "+ namefromdb, Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
//                //    finish();
//               // }
//            }
//        });
        ///////// end abhi code


//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                List<Object> list = null;
//                list.clear();
//                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
//                    list.add(snapshot.getValue());
//                }
//                Adapter adapter = null;
////                adapter.notify
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


//        Intent intent=getIntent();

//        String str=editTextAddAmount.getText().toString();
//        int added=Integer.parseInt(str);
//        intent.putExtra("added",added);
//        setResult(RESULT_OK,intent);


//        Continue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(add_balance.this, str+"money added", Toast.LENGTH_SHORT).show();
////                finish();
//            }
//        });

*/
    }


    //for read data into a firebase
    private int setData(@NonNull DatabaseReference databaseReference, TextView tbalance, int[] arr){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                int value = snapshot.child("amt").getValue(Integer.class);
                arr[0]=value;
                tbalance.setText(value+" .Cr");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
        return arr[0];
    }

}