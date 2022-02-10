package com.example.medmanager.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.medmanager.models.User;
import com.example.medmanager.repository.UserRepository;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    private String email;
    private String pass;
    private MutableLiveData<User> currentUser = new MutableLiveData<>();
    public LiveData<List<User>> user;
    private User cUser;
    private final UserRepository repository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.repository = new UserRepository(application);
        user = repository.getAllUsers();
    }


    public void authentication(){
        if (validationFields()){
            System.out.println("=======passou da validação");
            cUser = repository.getUserByEmail(email,pass);
            //System.out.println("--------borave"+repository.getUserByEmail(email,pass));
        }else {
            System.out.println("sem aut");
        }

    }

    public void setCurrentUser(User currentUser) {
        this.currentUser.setValue(currentUser);
    }

    public LiveData<User> getCurrentUser() {
        return currentUser;
    }

    private boolean validationFields(){
        if ( email == null || pass == null || email.equals("") || pass.equals("")) {

            System.out.println("---------rapaz n passou["+email+"] asas "+pass);
            return false;
        };
        return  true;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}