package com.example.medmanager.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.medmanager.models.User;

public class UserViewModel extends AndroidViewModel {
    private MutableLiveData<User> user;

    public UserViewModel(@NonNull Application application) {
        super(application);
        user.setValue(null);

    }

    public LiveData<User> user(){
        return user;
    }


}
