package com.example.medmanager.staticData;

import com.example.medmanager.models.Medicine;
import com.example.medmanager.models.User;
import java.util.ArrayList;
import java.util.List;

public class Data {
    // this class was utilized to populate locally data
    public static List<Medicine> medicines = new ArrayList<>();
    public static List<User> users;

    public static User getUserById(int id){
        if (users.isEmpty()){
            users.add(new User(0,"admin","admin"));
        }
        for (User user: users) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public static List<Medicine> getMedicines (){
        if(medicines.isEmpty()){
            medicines.add(new Medicine(0,"name1","valid", 100, 0.));
            medicines.add(new Medicine(1,"name2","valid", 100, 0.));
            medicines.add(new Medicine(2,"name3","valid", 100, 0.));
            medicines.add(new Medicine(3,"name4","valid", 100, 0.));
            medicines.add(new Medicine(4,"name5","valid", 100, 0.));
            medicines.add(new Medicine(5,"name6","valid", 100, 0.));
            medicines.add(new Medicine(6,"name7","valid", 100, 0.));
        }
        return medicines;
    }


    public static void addMedicine(int id, String name, String validity, int quantity, Double unityPrice){
        medicines.add(new Medicine(id,name,validity,quantity,unityPrice));
    }

    public static List<User> getUsers() {
        if (users.isEmpty()){
            users.add(new User(0,"admin","admin"));
        }
        return users;
    }


}
