package com.example.medmanager.ui.medicineRegister;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.medmanager.models.Medicine;

public class MedicineRegisterViewModel extends ViewModel {
    /*
    private MutableLiveData<Medicine> _onSaveMedicine;
    public LiveData<Medicine> onSaveMedicine = _onSaveMedicine;
    */

    private MutableLiveData<Medicine> _newMedicine;

    private Medicine currentMedicine = new Medicine();
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

    public void onUserRequestAddMedicine(Medicine medicine){
        setCurrentMedicine(medicine);
        _newMedicine.setValue(new Medicine("name","valid", 0, 0.));
    }

    public void setCurrentMedicine(Medicine currentMedicine) {
        this.currentMedicine = currentMedicine;
    }

}