package com.example.medmanager.ui.medicineEdit;

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
import com.example.medmanager.databinding.FragmentMedicineEditBinding;
import com.example.medmanager.models.Medicine;
import com.example.medmanager.viewModels.MedicineEditViewModel;

public class MedicineEditFragment extends Fragment {

    private MedicineEditViewModel editViewModel;
    private FragmentMedicineEditBinding binding;
    private Medicine currentItem;


    public static MedicineEditFragment newInstance() {
        return new MedicineEditFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMedicineEditBinding.inflate(inflater, container, false);
        editViewModel = new ViewModelProvider(this).get(MedicineEditViewModel.class);



        currentItem = MedicineEditFragmentArgs.fromBundle(getArguments()).getCurrentMedicine();
        editViewModel.setCurrentItemParams(currentItem);

        binding.buttonMedicineEditCancel.setOnClickListener( l -> {
            Navigation.findNavController(container).popBackStack();
        });

        binding.buttonMedicineEditSave.setOnClickListener( l -> {
            editViewModel.updateOnDataBase(currentItem);
            Navigation.findNavController(container).navigate(R.id.action_nav_medicine_edit_to_nav_home);
        });

        displayCurrentItemValuesOnScreem();
        setupFieldsListeners();

        View root = binding.getRoot();
        return root;
    }

    private void displayCurrentItemValuesOnScreem(){
        binding.inputMedicineEditName.setText(currentItem.getName());
        binding.inputMedicineEditQuantity.setText(Integer.toString(currentItem.getQuantity()));
        binding.inputMedicineEditUnityPrice.setText(currentItem.getUnityPrice().toString());
        binding.inputMedicineEditValidity.setText(currentItem.getValidity());
    }

    private void setupFieldsListeners() {
        setupNameListener();
        setupQuantityListener();
        setupValidityListener();
        setupPriceListener();
    }

    private void setupNameListener(){
        binding.inputMedicineEditName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editViewModel.onUserChangeName(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void setupQuantityListener(){
        binding.inputMedicineEditQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editViewModel.onUserChangeQuantity(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void setupValidityListener(){
        binding.inputMedicineEditValidity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editViewModel.onUserChangeValidity(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void setupPriceListener(){
        binding.inputMedicineEditUnityPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editViewModel.onUserChangeUnityPrice(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

}