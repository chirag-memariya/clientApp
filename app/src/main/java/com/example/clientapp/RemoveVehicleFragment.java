package com.example.clientapp;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class RemoveVehicleFragment extends Fragment {


    public RemoveVehicleFragment() {
        // Required empty public constructor
    }


     Button removeBtn;
    Spinner removeSpinner;


    String current_id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_remove_vehicle, container, false);
        removeBtn=view.findViewById(R.id.removeVehicleButton);
        removeSpinner=view.findViewById(R.id.selectVehivle);


        current_id=global_username.getUserid();


        SpinnerAdapter adapter=new SpinnerAdapter(getContext(),R.layout.costom_spinner_adapter,VehicleNumber.getVehicleNumbers());
        removeSpinner.setAdapter(adapter);
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("vehicle");
                Query applesQuery = ref.orderByChild("userId").equalTo(current_id);

                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot1: dataSnapshot.getChildren()) {
                            if((snapshot1.child("vehiclePlateNo").getValue(String.class)).equals(removeSpinner.getSelectedItem().toString())){
                                Toast.makeText(getContext(),"True",Toast.LENGTH_SHORT).show();
                            }
                            //snapshot1.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e(TAG, "onCancelled", databaseError.toException());
                    }
                });

                Toast.makeText(getContext(),"Removed Vehicle "+(removeSpinner.getSelectedItem().toString()),Toast.LENGTH_SHORT).show();
                removeSpinner.getItemAtPosition(removeSpinner.getSelectedItemPosition());
                Toast.makeText(getContext(),""+removeSpinner.getSelectedItem().toString().substring(35),Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }



}