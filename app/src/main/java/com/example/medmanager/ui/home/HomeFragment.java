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
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medmanager.R;
import com.example.medmanager.adapters.MedicineRecyclerAdapter;
import com.example.medmanager.databinding.FragmentHomeBinding;
import com.example.medmanager.models.Medicine;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private List<Medicine> data;
    private MedicineRecyclerAdapter adapter;
    private FloatingActionButton floatingButton;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        floatingButton = binding.fab;
        floatingButton.setOnClickListener( l -> {
            Navigation.findNavController(container).navigate(R.id.medicineRegisterFragment);
        });



        RecyclerView recyclerView = binding.recyclerViewMedicine;
        adapter = new MedicineRecyclerAdapter(getContext());
        recyclerView.setAdapter(adapter);

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));

        loadMedicineList();

        View root = binding.getRoot();
        return root;
    }

    public void loadMedicineList (){
        homeViewModel.getData().observe(getViewLifecycleOwner(), medicines -> {
            adapter.setMedicineList(medicines);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}