package com.example.signup.ui.register;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.signup.R;
import com.example.signup.base.BaseFragment;
import com.example.signup.databinding.FragmentForgetPasswordBinding;
import com.example.signup.viewmodel.RegisterViewModel;


public class ForgetPasswordFragment extends BaseFragment<FragmentForgetPasswordBinding, RegisterViewModel> implements View.OnClickListener {


    public ForgetPasswordFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_forget_password;
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

    private boolean validateNewPassword() {
        final String password = binding.passwordCustomEt.getText();
        if (password == null || password.length() < 8) {
            binding.passwordCustomEt.setError("رمز باید بیش از 8 کاراکتر باشد");
            return false;
        }
        binding.passwordCustomEt.setError(null);
        return true;
    }

    private boolean validateRepeatPassword() {
        final String password = binding.confirmPasswordCustomEt.getText();
        if (password == null || !password.equals(binding.passwordCustomEt.getText())) {
            binding.confirmPasswordCustomEt.setError("تکرار رمز صحیح نیست");
            return false;
        }
        binding.confirmPasswordCustomEt.setError(null);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.confirm_password_button) {
            if (validateNewPassword() | validateRepeatPassword()) {
                Toast.makeText(activity, "Password Updated!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}