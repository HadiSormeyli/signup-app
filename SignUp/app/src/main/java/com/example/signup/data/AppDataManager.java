package com.example.signup.data;

import com.example.signup.data.local.prefs.PreferencesHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {

    private final PreferencesHelper preferencesHelper;

    @Inject
    public AppDataManager(PreferencesHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
    }

    @Override
    public void signUpUser(String username, String phoneNumber, String password) {
        preferencesHelper.signUpUser(username, phoneNumber, password);
    }

    @Override
    public boolean isSignedUp() {
        return preferencesHelper.isSignedUp();
    }

    @Override
    public String getUserData() {
        return preferencesHelper.getUserData();
    }
}
