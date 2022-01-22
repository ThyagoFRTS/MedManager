package com.example.medmanager.ui.medicineRegister;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medmanager.R;


import com.example.medmanager.databinding.FragmentHomeBinding;
import com.example.medmanager.databinding.FragmentMedicineRegisterBinding;
import com.example.medmanager.models.Medicine;
import com.example.medmanager.ui.home.HomeViewModel;


public class MedicineRegisterFragment extends Fragment {

    private MedicineRegisterViewModel medicineViewModel;
    private FragmentMedicineRegisterBinding binding;

    private Medicine entry;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMedicineRegisterBinding.inflate(inflater, container, false);
        medicineViewModel = new ViewModelProvider(this).get(MedicineRegisterViewModel.class);

        Boolean result = MedicineRegisterFragmentArgs.fromBundle(getArguments()).getIsNewMedicine();
        if (result){
            System.out.println("==============================tem argumento"+ result.toString());
        }
        System.out.println("==============================tem argumento"+ result.toString());


        binding.buttonMedicineRegisterCancel.setOnClickListener( l -> {
            Navigation.findNavController(container).popBackStack();
            //Navigation.findNavController(container).navigate(R.id.action_medicine_register_to_nav_home);

        });

        binding.buttonMedicineRegisterSave.setOnClickListener(v -> {
            medicineViewModel.onSaveNewMedicine();
            Navigation.findNavController(container).navigate(R.id.action_medicine_register_to_nav_home);

        });



        setupFieldsListeners();
        setupOnClickListener();
        setupObservers();

        View root = binding.getRoot();
        return root;
    }



    private void setupObservers() {

        /*
        medicineViewModel.getNewMedicine().observe(getViewLifecycleOwner(), medicine -> {
            entry = medicine;

        });*/



    }

    private void setupOnClickListener() {
        String name = binding.inputMedicineRegisterName.getText().toString();
        /*
        String leaflet = binding.inputMedicineRegisterLeafleft.getText().toString();
        String price = binding.inputMedicineRegisterPrice.toString();

        binding.buttonMedicineRegisterSave.setOnClickListener(v -> {
            System.out.println("aaaaaaaaaaaaaONCLICKaaaaaaaaaaaaaaaaaaaa"+name);
            Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
            //medicineViewModel.onSaveNewMedicine();


        });
        */


    }

    private void setupFieldsListeners() {
        setupNameListener();
        setupQuantityListener();
        setupValidityListener();
        setupPriceListener();
    }

    private void setupNameListener(){
        binding.inputMedicineRegisterName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                medicineViewModel.onUserChangeName(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void setupQuantityListener(){
        binding.inputMedicineRegisterQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                medicineViewModel.onUserChangeQuantity(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void setupValidityListener(){
        binding.inputMedicineRegisterValidity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                medicineViewModel.onUserChangeValidity(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void setupPriceListener(){
        binding.inputMedicineRegisterUnityPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                medicineViewModel.onUserChangeUnityPrice(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }




}