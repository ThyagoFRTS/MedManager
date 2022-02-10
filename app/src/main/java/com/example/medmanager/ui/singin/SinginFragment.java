package com.example.medmanager.ui.singin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medmanager.R;
import com.example.medmanager.databinding.FragmentSinginBinding;
import com.example.medmanager.viewModels.SinginViewModel;

public class SinginFragment extends Fragment {

    private SinginViewModel singinViewModel;
    private FragmentSinginBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        binding = FragmentSinginBinding.inflate(inflater,container,false);
        singinViewModel = new ViewModelProvider(this).get(SinginViewModel.class);


        setupFieldsListeners();
        
        binding.buttonSinginRegister.setOnClickListener(v -> {
                singinViewModel.onCreateNewUser();

            }
        );



        singinViewModel.getAllUsers().observe(getViewLifecycleOwner(),users -> {
            binding.tosee.setText(users.toString());
        });

        binding.buttonSinginCancel.setOnClickListener( v -> {

            singinViewModel.getUserById(1);
        });

        return binding.getRoot();
    }

    private void setupFieldsListeners() {
        setupNameListener();
        setupEmailListener();
        setupPassListener();
        setupConfirmPassListener();
    }


    private void setupNameListener(){
        binding.inputSinginName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                singinViewModel.setName(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setupEmailListener(){
        binding.inputSinginEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                singinViewModel.setEmail(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setupPassListener(){
        binding.inputSinginPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                singinViewModel.setPass(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setupConfirmPassListener(){
        binding.inputSinginConfirmpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                singinViewModel.setConfirmPass(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}