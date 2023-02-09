package com.example.clientapp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogsModel {
    String numberPlate;
    float fees;
    String inTime;
    String outTime;
    @RequiresApi(api = Build.VERSION_CODES.O)
    public LogsModel(String numberPlate, float fees, LocalDateTime inTime, LocalDateTime outTime){
        this.fees=fees;
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy\n HH:mm");
        String formattedDate = inTime.format(myFormatObj);
        this.inTime=formattedDate;


        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy\n HH:mm");
        String formatted = outTime.format(myFormat);
        this.outTime=formatted;
        this.numberPlate=numberPlate;
    }
}
