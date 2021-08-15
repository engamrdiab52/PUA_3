package com.afdal.pua_3.ui

import androidx.lifecycle.*
import com.afdal.pua_3.repository.MainRepository
import com.afdal.pua_3.repository.source.remoteDataSource.FirebaseResponseStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: MainRepository) : ViewModel() {

    private val _status = repository.firebaseResponseStatus as MutableLiveData<FirebaseResponseStatus>
    val status: LiveData<FirebaseResponseStatus>
        get() = _status

     suspend fun provideName() {
        repository.refreshProfile()
    }

    init {
        startNetworking()
    }

    fun getResponseFirebase(): LiveData<String> {
        return repository.profileName
    }

    private fun startNetworking() {
        viewModelScope.launch(Dispatchers.IO) {
            provideName()
        }
    }

    companion object {
        /**
         * Factory for creating [ProfileViewModel]
         *
         * @param arg the repository to pass to [ProfileViewModel]
         */
        val FACTORY: (MainRepository) -> ViewModelProvider.NewInstanceFactory = singleArgViewModelFactory(::ProfileViewModel)
    }

}

fun <T : ViewModel, A> singleArgViewModelFactory(constructor: (A) -> T):
            (A) -> ViewModelProvider.NewInstanceFactory {
    return { arg: A ->
        object : ViewModelProvider.NewInstanceFactory() {
            @Suppress("UNCHECKED_CAST")
            override fun <V : ViewModel> create(modelClass: Class<V>): V {
                return constructor(arg) as V
            }
        }
    }
}
