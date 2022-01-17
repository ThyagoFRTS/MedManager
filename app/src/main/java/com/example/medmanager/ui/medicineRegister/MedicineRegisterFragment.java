package com.example.medmanager.ui.medicineRegister;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medmanager.R;


import com.example.medmanager.databinding.FragmentMedicineRegisterBinding;
import com.example.medmanager.models.Medicine;


public class MedicineRegisterFragment extends Fragment {

    private MedicineRegisterViewModel medicineViewModel;
    private FragmentMedicineRegisterBinding binding;
    public static MedicineRegisterFragment newInstance() {
        return new MedicineRegisterFragment();
    }
    private TextView txt_name;
    private TextView txt_price;
    private TextView txt_leafleft;
    private Button btn_save;

    private Medicine entry;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        medicineViewModel = new ViewModelProvider(this).get(MedicineRegisterViewModel.class);
        binding = FragmentMedicineRegisterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        txt_name = binding.inputMedicineRegisterName;
        txt_price = binding.inputMedicineRegisterPrice;
        txt_leafleft = binding.inputMedicineRegisterLeafleft;
        btn_save = binding.buttonMedicineRegisterSave;

        setupOnFieldsListeners();
        setupOnClickListener();
        setupObservers();

        return root;
    }

    private void setupOnFieldsListeners() {

    }

    private void setupObservers() {
        /*
        medicineViewModel.getNewMedicine().observe(getViewLifecycleOwner(), medicine -> {
            entry = medicine;

        });*/



    }

    private void setupOnClickListener() {
        String name = txt_name.getText().toString();
        String leaflet = binding.inputMedicineRegisterLeafleft.getText().toString();
        String price = binding.inputMedicineRegisterPrice.toString();

        Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
        binding.buttonMedicineRegisterSave.setOnClickListener(v -> {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+entry.getName());
            Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
            //medicineViewModel.onUserRequestAddMedicine(new Medicine(name, Double.parseDouble(price),leaflet));

        });

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}