package com.example.signup.ui.register;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.signup.R;
import com.example.signup.base.BaseFragment;
import com.example.signup.databinding.FragmentRegisterBinding;
import com.example.signup.viewmodel.RegisterViewModel;


public class RegisterFragment extends BaseFragment<FragmentRegisterBinding, RegisterViewModel> implements View.OnClickListener {


    public RegisterFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void performViewModel() {
        viewModel = new ViewModelProvider(activity).get(RegisterViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signup_button:
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_registerFragment_to_signUpFragment);
                break;

            case R.id.login_button:
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_registerFragment_to_loginFragment);
                break;
        }
    }
}