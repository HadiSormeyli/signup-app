package com.example.signup.data.local.prefs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {

    public static final String USER_NAME = "USER_NAME";
    public static final String PHONE_NUMBER = "PHONE_NUMBER";
    public static final String PASSWORD = "PASSWORD";
    private static final String PREFERENCE_NAME = "sport";
    private final SharedPreferences sharedPreferences;

    @Inject
    public AppPreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void signUpUser(String username, String phoneNumber, String password) {
        @SuppressLint("CommitPrefEdits")
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, username);
        editor.putString(PHONE_NUMBER, phoneNumber);
        editor.putString(PASSWORD, password);
        editor.apply();
    }

    @Override
    public boolean isSignedUp() {
        return sharedPreferences.getString(USER_NAME, null) != null;
    }

    @Override
    public String getUserData() {
        return sharedPreferences.getString(USER_NAME, null) + "\n" +
                sharedPreferences.getString(PHONE_NUMBER, null) + "\n" +
                sharedPreferences.getString(PASSWORD, null) + "\n";
    }
}
