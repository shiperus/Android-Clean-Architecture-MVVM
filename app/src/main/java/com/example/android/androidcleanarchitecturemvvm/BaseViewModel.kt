package com.example.android.androidcleanarchitecturemvvm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
    var viewState: MutableLiveData<ViewState> = MutableLiveData()
}