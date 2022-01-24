package com.example.medmanager.ui.medicineRegister;

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
import com.example.medmanager.R;
import com.example.medmanager.databinding.FragmentMedicineRegisterBinding;
import com.example.medmanager.viewModels.MedicineRegisterViewModel;


public class MedicineRegisterFragment extends Fragment {

    private MedicineRegisterViewModel medicineViewModel;
    private FragmentMedicineRegisterBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMedicineRegisterBinding.inflate(inflater, container, false);
        medicineViewModel = new ViewModelProvider(this).get(MedicineRegisterViewModel.class);

        binding.buttonMedicineRegisterCancel.setOnClickListener( l -> {
            assert container != null;
            Navigation.findNavController(container).popBackStack();
        });

        binding.buttonMedicineRegisterSave.setOnClickListener(v -> {
            medicineViewModel.onSaveNewMedicine();
            assert container != null;
            Navigation.findNavController(container).navigate(R.id.action_medicine_register_to_nav_home);
        });

        setupFieldsListeners();

        return binding.getRoot();
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