package com.example.signup.ui.register;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.signup.R;
import com.example.signup.base.BaseFragment;
import com.example.signup.databinding.FragmentSignUpBinding;
import com.example.signup.ui.MainActivity;
import com.example.signup.viewmodel.RegisterViewModel;

public class SignUpFragment extends BaseFragment<FragmentSignUpBinding, RegisterViewModel> implements View.OnClickListener {


    public SignUpFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_sign_up;
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

    private boolean validateUsername() {
        final String username = binding.usernameCustomEt.getText();
        if (username == null || username.length() < 4) {
            binding.usernameCustomEt.setError("نام کاربری باید بیش از 4 کاراکتر باشد");
            return true;
        }
        binding.usernameCustomEt.setError(null);
        return false;
    }

    private boolean validatePhoneNumber() {
        final String phoneNumber = binding.phoneCustomEt.getText();
        final String PATTERN = "^[+]?[0-9]{10,13}$";
        if (phoneNumber == null || !phoneNumber.matches(PATTERN)) {
            binding.phoneCustomEt.setError("شماره تلفن صحیح نیست");
            return true;
        }
        binding.phoneCustomEt.setError(null);
        return false;
    }

    private boolean validatePassword() {
        final String password = binding.passwordCustomEt.getText();
        if (password == null || password.length() < 8) {
            binding.passwordCustomEt.setError("رمز باید بیش از 8 کاراکتر باشد");
            return true;
        }
        binding.passwordCustomEt.setError(null);
        return false;
    }

    private void navigateToLoginFragment() {
        NavHostFragment navHostFragment = (NavHostFragment) this.getParentFragment();
        if (navHostFragment != null && navHostFragment.getChildFragmentManager().getBackStackEntryCount() > 1) {
            Navigation.findNavController(binding.getRoot()).popBackStack();
        } else
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_signUpFragment_to_loginFragment);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signup_button:
                if (validateUsername() | validatePhoneNumber() | validatePassword()) {
                    return;
                }

                viewModel.dataManager.signUpUser(
                        binding.usernameCustomEt.getText()
                        , binding.phoneCustomEt.getText()
                        , binding.passwordCustomEt.getText());
                startActivity(MainActivity.newIntent(activity));
                activity.finish();
                break;

            case R.id.login_text_view:
                navigateToLoginFragment();
                break;
        }
    }
}