package com.example.clientapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class RemoveVehicleFragment extends Fragment {


    public RemoveVehicleFragment() {
        // Required empty public constructor
    }


     Button removeBtn;
    Spinner removeSpinner;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_remove_vehicle, container, false);
        removeBtn=view.findViewById(R.id.removeVehicleButton);
        removeSpinner=view.findViewById(R.id.selectVehivle);
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Removed Vehicle "+removeSpinner.getSelectedItemPosition(),Toast.LENGTH_SHORT).show();
            }
        });

        SpinnerAdapter adapter=new SpinnerAdapter(getContext(),R.layout.costom_spinner_adapter,VehicleNumber.getVehicleNumbers());
        removeSpinner.setAdapter(adapter);



        return view;
    }
}