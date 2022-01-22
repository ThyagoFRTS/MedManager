package com.example.medmanager.ui.medicineRegister;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.medmanager.domain.MedicineRepository;
import com.example.medmanager.models.Medicine;
import com.example.medmanager.staticData.Data;

import java.util.List;

public class MedicineRegisterViewModel extends AndroidViewModel {
    private MedicineRepository repository;
    /*
    private MutableLiveData<Medicine> _onSaveMedicine;
    public LiveData<Medicine> onSaveMedicine = _onSaveMedicine;
    */
    private MutableLiveData<Medicine> _newMedicine;
    private Medicine new_item;

    private String name;
    private String validity;
    private String quantity;
    private String unity_pice;

    public MedicineRegisterViewModel(@NonNull Application application) {
        super(application);
        this.repository = new MedicineRepository(application);

    }

    /*
    public LiveData<Medicine> getNewMedicine() {
        if (_newMedicine == null) {
            _newMedicine = new MutableLiveData<Medicine>();
            loadUser();
        }
        return _newMedicine;
    }

    private void loadUser() {
        _newMedicine.setValue(new Medicine("name", 0.,"leaflet"));
    }*/



    public void onSaveNewMedicine(){
        if (!name.equals("") && !validity.equals("") && !quantity.equals("") && !unity_pice.equals("")){
            //repository.insert(new Medicine(name,validity,Integer.parseInt(quantity),Double.parseDouble(unity_pice)));
            //_newMedicine.setValue(new Medicine("name","valid", 0, 0.));
            Data.addMedicine(9,"name","valid", 0, 0.);
        }
    }


    public void saveOnDataBase() {
        //repository.insert();
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

    public void onUserChangeUnityPrice(String unity_pice) {
        this.unity_pice = unity_pice;
    }
}