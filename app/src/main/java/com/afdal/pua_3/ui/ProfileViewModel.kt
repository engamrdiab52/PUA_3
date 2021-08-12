package com.afdal.pua_3.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afdal.pua_3.repository.source.localSource.MainRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: MainRepository) : ViewModel() {

    val userName: LiveData<String>
        get() = repository.userName

    init {
        //  _userName.value = getUserName()
    }

    fun getUserName() {
        viewModelScope.launch {
            try {
                repository.getUserNameRepo()
            } catch (throwable: Throwable) {
                throw Throwable()
            }
        }



    }
}