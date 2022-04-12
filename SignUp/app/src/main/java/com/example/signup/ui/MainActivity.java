package com.example.signup.ui;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.ViewModelProvider;

import com.example.signup.R;
import com.example.signup.base.BaseActivity;
import com.example.signup.databinding.ActivityMainBinding;
import com.example.signup.ui.register.RegisterActivity;
import com.example.signup.viewmodel.MainViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void performViewModel() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }
}