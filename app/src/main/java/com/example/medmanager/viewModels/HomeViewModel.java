package com.example.medmanager.viewModels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.medmanager.repository.MedicineRepository;
import com.example.medmanager.models.Medicine;
import java.util.List;


public class HomeViewModel extends AndroidViewModel {

    private final LiveData<List<Medicine>> data;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        MedicineRepository repository = new MedicineRepository(application);
        //data = _data;
        data = repository.getAllMedicines();


    }



    public LiveData<List<Medicine>> getAllMedicines() {
        return this.data;
    }


}