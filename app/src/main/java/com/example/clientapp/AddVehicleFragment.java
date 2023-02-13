package com.example.clientapp;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;


public class AddVehicleFragment extends Fragment {

    public AddVehicleFragment() {
        // Required empty public constructor
    }


    private Spinner spinner;
    ProgressBar progressBar;
    TextInputEditText editText;

    private Button addVechileBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_vehicle, container, false);


        editText=view.findViewById(R.id.idEdtVechile);
        progressBar=view.findViewById(R.id.idPBLoading);
        spinner=view.findViewById(R.id.selectCategoeryspinner);
        addVechileBtn=view.findViewById(R.id.addVehicleButton);
        ArrayList<VehicleNumber> category=new ArrayList<>();
        category.add(new VehicleNumber(1,"Car"));
        category.add(new VehicleNumber(2,"Bike"));

        SpinnerAdapter spinnerAdapter=new SpinnerAdapter(getContext(),R.layout.costom_spinner_adapter,category);
        spinner.setAdapter(spinnerAdapter);


        addVechileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(),"Adding vechile"+editText.getText().toString()+spinner.getSelectedItem(),LENGTH_SHORT).show();
            }
        });


        return view;
    }
}