package com.afdal.pua_3.repository.source.localSource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class MainRepository {
    private val _userName = MediatorLiveData<String>()
    val userName: LiveData<String>
        get() = _userName

     fun getUserNameRepo() {
        _userName.value = "YasminAmyTalia"
    }
}
