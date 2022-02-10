package com.example.medmanager.viewModels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.medmanager.models.User;
import com.example.medmanager.repository.MedicineRepository;
import com.example.medmanager.models.Medicine;

import java.util.ArrayList;
import java.util.List;


public class HomeViewModel extends AndroidViewModel {
    private MutableLiveData<User> currentUser = new MutableLiveData<User>();
    private final LiveData<List<Medicine>> data;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        MedicineRepository repository = new MedicineRepository(application);
        data = repository.getAllMedicines();
    }

    public LiveData<User> getCurrentUser() {
        return currentUser;
    }

    public LiveData<List<Medicine>> getAllMedicines() {
        return this.data;
    }
}