package com.afdal.pua_3.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afdal.pua_3.repository.source.localSource.MainRepository
import com.afdal.pua_3.utilis.singleArgViewModelFactory
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: MainRepository) : ViewModel() {

    val name: LiveData<String>
        get() = repository.userName

    init {
     getUserName()
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
    companion object {
        /**
         * Factory for creating [MainViewModel]
         *
         * @param arg the repository to pass to [MainViewModel]
         */
        val FACTORY = singleArgViewModelFactory(::ProfileViewModel)
    }

}