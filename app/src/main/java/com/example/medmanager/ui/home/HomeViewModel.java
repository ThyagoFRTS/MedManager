package com.example.medmanager.ui.home;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.medmanager.db.DbRoomDatabase;
import com.example.medmanager.domain.MedicineRepository;
import com.example.medmanager.models.Medicine;
import com.example.medmanager.staticData.Data;

import java.util.List;


public class HomeViewModel extends AndroidViewModel {
    private MedicineRepository repository;
    private MutableLiveData<List<Medicine>> _data;
    LiveData<List<Medicine>> data;
    private Context context;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.repository = new MedicineRepository(application);
        //data = _data;
        loadData();

    }

    private void loadData() {
        if (this._data == null) {
            this._data = new MutableLiveData<>();
            loadDbData();
        }
    }

    public LiveData<List<Medicine>> getData() {
        if (_data == null) {
            /*
            System.out.println("==========chegouaqui");
            data = new MutableLiveData<>();
            loadDBData();
            */
        }
        return _data;
    }



    private void loadDbData() {
        //DbRoomDatabase db = DbRoomDatabase.getDatabase(context);
        //data = db.medicineDao().getAllMedicines();
        //_data = (MutableLiveData<List<Medicine>>) this.repository.getAllMedicines();
        _data.setValue(Data.getMedicines());
    }

    public void setData(List<Medicine> medicines) {
        _data.setValue(medicines);
    }

    /*
    public void insertMedicine(Medicine medicine) {
        repository.insert(medicine);
    }

    public void updateMedicine(Medicine medicine) {
        repository.update(medicine);
    }

    public void deleteMedicine(Medicine medicine){
        repository.delete(medicine);
    }

    public void deleteAll (){
        repository.deleteAll();
    }*/
}