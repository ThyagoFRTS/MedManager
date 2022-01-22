package com.example.medmanager.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.medmanager.models.Medicine;
import com.example.medmanager.staticData.Data;

import java.util.List;


public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Medicine>> data;
    //private List<Medicine> medicines;

    public HomeViewModel() {

        //data = new MutableLiveData<>();
        //mText.setValue("This is home fragment");

        loadData();

    }

    private void loadData() {
        if (this.data == null) {
            this.data = new MutableLiveData<>();
            loadDBData();
        }
    }

    public LiveData<List<Medicine>> getData() {
        if (data == null) {

            /*
            System.out.println("==========chegouaqui");
            data = new MutableLiveData<>();
            loadDBData();
            */
        }
        return data;
    }



    private void loadDBData() {
        data.setValue(Data.getMedicines());
    }

    private void setData(List<Medicine> medicines) {
        data.setValue(medicines);
    }
}