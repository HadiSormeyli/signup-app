package com.example.signup.ui.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.signup.R;
import com.example.signup.base.BaseActivity;
import com.example.signup.databinding.ActivityRegisterBinding;
import com.example.signup.viewmodel.RegisterViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegisterViewModel> {

    private NavHostFragment navHostFragment;

    public static Intent newIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void performViewModel() {
        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.register_fragment);
    }
}