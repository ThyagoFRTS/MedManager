package com.example.medmanager.viewModels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.medmanager.repository.MedicineRepository;
import com.example.medmanager.models.Medicine;



public class MedicineEditViewModel extends AndroidViewModel {
    private final MedicineRepository repository;
    private String name;
    private String validity;
    private String quantity;
    private String unity_price;

    public MedicineEditViewModel(@NonNull Application application) {
        super(application);
        this.repository = new MedicineRepository(application);

    }


    public void updateOnDataBase(Medicine currentItem){
        System.out.println("==========="+this.quantity);
        currentItem.setName(this.name);
        currentItem.setValidity(this.validity);
        currentItem.setQuantity(Integer.parseInt(this.quantity));
        currentItem.setUnityPrice(Double.parseDouble(this.unity_price));
        System.out.println("======================="+currentItem.toString());
        this.repository.update(currentItem);
    }

    public void deleteOnDataBase(Medicine medicine){
        this.repository.delete(medicine);
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

    public void setCurrentItemParams(Medicine currentItem) {
        this.name = currentItem.getName();
        this.validity = currentItem.getValidity();
        this.quantity = Integer.toString(currentItem.getQuantity());
        this.unity_price = Double.toString(currentItem.getUnityPrice());

    }
}