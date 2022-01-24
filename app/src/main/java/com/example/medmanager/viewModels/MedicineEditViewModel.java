package com.example.medmanager.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.medmanager.domain.MedicineRepository;
import com.example.medmanager.models.Medicine;



public class MedicineEditViewModel extends AndroidViewModel {
    private MedicineRepository repository;
    private MutableLiveData<Medicine> entry;
    private Medicine medicineToEdit;
    private String name;
    private String validity;
    private String quantity;
    private String unity_price;
    private int itemId;

    public MedicineEditViewModel(@NonNull Application application) {
        super(application);
        this.repository = new MedicineRepository(application);

    }

    public void setMedicineToEdit(Medicine currentMedicine){
        this.medicineToEdit = currentMedicine;
    }



    public void updateItem(Medicine item){
        this.repository.update(item);
    }



    public void onUserChangeName(String name) {
        System.out.println("=============diji"+name);
        this.entry.getValue().setName(name);
    }

    public void onUserChangeValidity(String validity) {
        this.entry.getValue().setValidity(validity);
    }

    public void onUserChangeQuantity(String quantity) {
        this.entry.getValue().setQuantity(Integer.parseInt(quantity));
    }

    public void onUserChangeUnityPrice(String unity_price) {
        this.entry.getValue().setUnityPrice(Double.parseDouble(unity_price));
    }
}