package com.example.medmanager.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medmanager.adapters.MedicineRecyclerAdapter;
import com.example.medmanager.databinding.FragmentHomeBinding;
import com.example.medmanager.models.Medicine;

import java.util.List;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private List<Medicine> data;
    private MedicineRecyclerAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        /*
        homeViewModel.getMedicines().observe(getViewLifecycleOwner(), medicines -> {
            data = medicines;
            System.out.println("================jasjaijsiajsiajsiajisjaisjiajsiaji"+data.get(0).getName());
        });*/




        RecyclerView recyclerView = binding.recyclerViewMedicine;
        adapter = new MedicineRecyclerAdapter(getContext());
        recyclerView.setAdapter(adapter);

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));

        //getAllMedicines();

        View root = binding.getRoot();
        return root;
    }

    public void getAllMedicines (){
        homeViewModel.getMedicines().observe(getViewLifecycleOwner(), medicines -> {
            adapter.setMedicineList(medicines);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}