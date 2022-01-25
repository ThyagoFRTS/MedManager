package com.example.medmanager.ui.singin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medmanager.R;
import com.example.medmanager.viewModels.SinginViewModel;

public class SinginFragment extends Fragment {

    private SinginViewModel singinViewModel;

    public static SinginFragment newInstance() {
        return new SinginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_singin, container, false);
    }


}