package com.example.signup.ui.register;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.signup.R;
import com.example.signup.base.BaseFragment;
import com.example.signup.databinding.FragmentLoginBinding;
import com.example.signup.viewmodel.RegisterViewModel;


public class LoginFragment extends BaseFragment<FragmentLoginBinding, RegisterViewModel> implements View.OnClickListener {


    public LoginFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void performViewModel() {
        viewModel = new ViewModelProvider(activity).get(RegisterViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.setOnClickListener(this);
    }

    private boolean validateUsername() {
        final String username = binding.usernameCustomEt.getText();
        if (username == null || username.length() < 4) {
            binding.usernameCustomEt.setError("نام کاربری باید بیش از 4 کاراکتر باشد");
            return false;
        }
        binding.usernameCustomEt.setError(null);
        return true;
    }

    private boolean validatePassword() {
        final String password = binding.passwordCustomEt.getText();
        if (password == null || password.length() < 8) {
            binding.passwordCustomEt.setError("رمز باید بیش از 8 کاراکتر باشد");
            return false;
        }
        binding.passwordCustomEt.setError(null);
        return true;
    }

    public void navigateToSignUpFragment() {
        NavHostFragment navHostFragment = (NavHostFragment) this.getParentFragment();
        if (navHostFragment != null && navHostFragment.getChildFragmentManager().getBackStackEntryCount() > 1) {
            Navigation.findNavController(binding.getRoot()).popBackStack();
        } else
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_loginFragment_to_signUpFragment);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                if (validateUsername() | validatePassword()) {
                    Toast.makeText(activity, "Login", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.signup_text_view:
                navigateToSignUpFragment();
                break;

            case R.id.forget_password_tv:
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_loginFragment_to_forgetPasswordFragment);
                break;
        }
    }
}