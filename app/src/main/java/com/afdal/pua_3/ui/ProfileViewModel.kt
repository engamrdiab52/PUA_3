package com.afdal.pua_3.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String>
        get() = _userName
    init {
        _userName.value = "YasminAmyTalia"
    }
}