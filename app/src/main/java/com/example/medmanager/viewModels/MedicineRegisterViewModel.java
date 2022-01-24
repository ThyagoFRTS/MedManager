package com.example.medmanager.viewModels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.medmanager.domain.MedicineRepository;
import com.example.medmanager.models.Medicine;

public class MedicineRegisterViewModel extends AndroidViewModel {
    private final MedicineRepository repository;

    private String name;
    private String validity;
    private String quantity;
    private String unity_price;

    public MedicineRegisterViewModel(@NonNull Application application) {
        super(application);
        this.repository = new MedicineRepository(application);

    }


    public void onSaveNewMedicine(){
        if (!name.equals("") && !validity.equals("") && !quantity.equals("") && !unity_price.equals("")){
            saveOnDataBase();
        }
    }


    public void saveOnDataBase() {
        repository.insert(new Medicine(name,validity,Integer.parseInt(quantity),Double.parseDouble(unity_price)));
    }

    public void onUserChangeName(String name) {
        this.name = name;
    }

    public void onUserChangeValidity(String validity) {
        this.validity = validity;
    }

    public void onUserChangeQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void onUserChangeUnityPrice(String unity_price) {
        this.unity_price = unity_price;
    }
}