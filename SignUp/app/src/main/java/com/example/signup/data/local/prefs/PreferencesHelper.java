package com.example.signup.data.local.prefs;

public interface PreferencesHelper {

    void signUpUser(String username, String phoneNumber, String password);

    boolean isSignedUp();

    String getUserData();
}
