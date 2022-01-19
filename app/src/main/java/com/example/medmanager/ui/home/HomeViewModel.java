package com.example.medmanager.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.medmanager.models.Medicine;
import com.example.medmanager.staticData.Data;

import java.util.List;
import java.util.Objects;

public class HomeViewModel extends ViewModel {

    final private MutableLiveData<String> mText;
    private MutableLiveData<List<Medicine>> data;
    //private List<Medicine> medicines;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        //data = new MutableLiveData<>();
        mText.setValue("This is home fragment");

    }

    public LiveData<List<Medicine>> getMedicines() {
        if (data == null) {
            data = new MutableLiveData<>();
            loadData();
            System.out.println("====================asasas========="+ Objects.requireNonNull(data.getValue()).get(0).getName());

        }
        return data;
    }

    private void loadData() {
        data.setValue(Data.getMedicines());
    }
}