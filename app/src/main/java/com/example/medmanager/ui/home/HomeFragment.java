package com.example.medmanager.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medmanager.R;
import com.example.medmanager.adapters.MedicineRecyclerAdapter;
import com.example.medmanager.databinding.FragmentHomeBinding;
import com.example.medmanager.models.User;
import com.example.medmanager.viewModels.HomeViewModel;
import com.example.medmanager.viewModels.UserViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;



public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private MedicineRecyclerAdapter adapter;
    private UserViewModel userViewModel;
    private User currentUser;

    public HomeFragment() {
    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        //currentUser = HomeFragmentArgs.fromBundle(savedInstanceState).getCurrentUser();


        /*
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

         */

        FloatingActionButton floatingButton = binding.fab;
        floatingButton.setOnClickListener(l -> Navigation.findNavController(container).navigate(R.id.nav_medicine_register));



        RecyclerView recyclerView = binding.recyclerViewMedicine;
        adapter = new MedicineRecyclerAdapter(getContext());

        recyclerView.setAdapter(adapter);

        loadMedicineList();


        return binding.getRoot();
    }

    public void loadMedicineList (){
        //homeViewModel.getData().observe(getViewLifecycleOwner(), medicines -> adapter.setMedicineList(medicines));
        homeViewModel.getAllMedicines().observe(this.getViewLifecycleOwner(), medicines -> adapter.setMedicineList(medicines));

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}