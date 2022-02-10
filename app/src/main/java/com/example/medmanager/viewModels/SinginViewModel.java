package com.example.medmanager.viewModels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.medmanager.models.Medicine;
import com.example.medmanager.models.User;
import com.example.medmanager.repository.UserRepository;

import java.sql.SQLOutput;
import java.util.List;

public class SinginViewModel extends AndroidViewModel {
    private String name, email, pass, confirmPass;
    private MutableLiveData<User> u;
    private LiveData<List<User>> data;
    private LiveData<List<Medicine>> med;
    private final UserRepository repository;

    public SinginViewModel(@NonNull Application application) {
        super(application);
        this.repository = new UserRepository(application);
        data = repository.getAllUsers();
        med = repository.getAllMedicines();
    }

    public void onCreateNewUser(){
        if (validationFields()){
            repository.insert(new User(name, email, pass));
            System.out.println("-----------------------------criou");
        }else{
            System.out.println("-----------------------------n criou");
        }
    }

    public void getUserById(int uid){
        new Thread(() -> {
            User a = repository.getUserById(1);
            System.out.println("=================useses===="+ a.toString());
        }).start();
    }

    public void getUserId(int uid){
        new Thread(() -> {
            User a = repository.getUserById(1);
            System.out.println("=================useses===="+ a.toString());
        }).start();
    }

    public LiveData<List<User>> getAllUsers() {
        return data;
    }

    public LiveData<List<Medicine>> getAllMedicines() {
        return med;
    }

    public void setData(LiveData<List<User>> data) {
        this.data = data;
    }

    public LiveData<User> getU(){
        return u;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    private boolean validationFields(){
        if (name.equals("") || email.equals("") || pass.equals("") || confirmPass.equals("")){
            return false;
        }
        if (!pass.equals(confirmPass)){
            return false;
        }
        return  true;
    }
}