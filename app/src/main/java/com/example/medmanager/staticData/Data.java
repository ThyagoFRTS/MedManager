package com.example.medmanager.staticData;

import com.example.medmanager.models.Medicine;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Medicine> getMedicines (){
        List<Medicine> medicines = new ArrayList<Medicine>();
        medicines.add(new Medicine("0","name1","valid", 0, 0.));
        medicines.add(new Medicine("1","name2","valid", 0, 0.));
        medicines.add(new Medicine("2","name3","valid", 0, 0.));
        medicines.add(new Medicine("3","name4","valid", 0, 0.));
        medicines.add(new Medicine("4","name5","valid", 0, 0.));
        medicines.add(new Medicine("5","name6","valid", 0, 0.));
        medicines.add(new Medicine("6","name7","valid", 0, 0.));
        return medicines;
    }
}
