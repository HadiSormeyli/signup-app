package com.example.signup.base;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

import com.example.signup.data.DataManager;

public abstract class BaseViewModel extends ViewModel {

    public final DataManager dataManager;
    private final ObservableBoolean mIsLoading = new ObservableBoolean();

    public BaseViewModel(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
