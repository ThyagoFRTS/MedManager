package com.example.medmanager.staticData;

import com.example.medmanager.models.Medicine;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Medicine> medicines = new ArrayList<Medicine>();

    public static List<Medicine> getMedicines (){
        medicines.add(new Medicine("0","name1","valid", 100, 0.));
        medicines.add(new Medicine("1","name2","valid", 100, 0.));
        medicines.add(new Medicine("2","name3","valid", 100, 0.));
        medicines.add(new Medicine("3","name4","valid", 100, 0.));
        medicines.add(new Medicine("4","name5","valid", 100, 0.));
        medicines.add(new Medicine("5","name6","valid", 100, 0.));
        medicines.add(new Medicine("6","name7","valid", 100, 0.));
        return medicines;
    }

    public static void addMedicine(String id, String name, String validity, int quantity, Double unityPrice){
        medicines.add(new Medicine(id,name,validity,quantity,unityPrice));
    }
}
