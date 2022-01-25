package com.example.medmanager.viewModels;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private String email;
    private String pass;




    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}