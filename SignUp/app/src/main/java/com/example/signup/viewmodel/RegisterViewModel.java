package com.example.signup.viewmodel;

import com.example.signup.base.BaseViewModel;
import com.example.signup.data.DataManager;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class RegisterViewModel extends BaseViewModel {

    @Inject
    public RegisterViewModel(DataManager dataManager) {
        super(dataManager);
    }
}
