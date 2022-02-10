package com.example.medmanager.ui.login;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.medmanager.R;
import com.example.medmanager.databinding.FragmentLoginBinding;
import com.example.medmanager.models.User;
import com.example.medmanager.ui.home.HomeFragment;
import com.example.medmanager.ui.home.HomeFragmentDirections;
import com.example.medmanager.viewModels.LoginViewModel;
import com.example.medmanager.viewModels.UserViewModel;

public class LoginFragment extends Fragment {
    public static String LOGIN_SUCCESSFUL = "LOGIN_SUCCESSFUL";
    private LoginViewModel loginViewModel;
    private UserViewModel userViewModel;
    private FragmentLoginBinding binding;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        loginViewModel.getCurrentUser().observe(getViewLifecycleOwner(), user -> {
            if (user != null){
                LoginFragmentDirections.ActionNavLoginToNavHome action;
                action = LoginFragmentDirections.actionNavLoginToNavHome(user);
                Navigation.findNavController(container).navigate(action);
            }
        });


        binding.buttonLoginSingin.setOnClickListener(l -> {
            Navigation.findNavController(container).navigate(R.id.action_nav_login_to_nav_singin);
        });

        loginViewModel.user.observe(getViewLifecycleOwner(),users -> {
            binding.tosee2.setText(users.toString());
        });

        binding.buttonLoginLogin.setOnClickListener(l -> {
            new Thread(() -> {
                loginViewModel.authentication();
            }).start();

        });

        setupFieldsListeners();

        return binding.getRoot();
    }
    /*

    private void login(String username, String password) {
        userViewModel.login(username, password).observe(viewLifecycleOwner, (Observer<LoginResult>) result -> {
            if (result.success) {
                savedStateHandle.set(LOGIN_SUCCESSFUL, true);
                NavHostFragment.findNavController(this).popBackStack();
            } else {
                showErrorMessage();
            }
        });
    }*/

    private void showErrorMessage() {
        // Display a snackbar error message
    }

    private void setupFieldsListeners(){
        setupEmailListener();
        setupPassListener();
    }


    private void setupEmailListener(){
        binding.inputLoginEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginViewModel.setEmail(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setupPassListener(){
        binding.inputLoginPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginViewModel.setPass(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



}