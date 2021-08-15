package com.afdal.pua_3.ui

import androidx.lifecycle.*
import com.afdal.pua_3.repository.source.localSource.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: MainRepository) : ViewModel() {

    private val _status = repository.status as MutableLiveData<FirebaseResponseStatus>
    val status: LiveData<FirebaseResponseStatus>
        get() = _status

    private suspend fun provideName() {
        repository.provideName()
    }

    init {
        startNetworking()
    }

    fun getResponseFirebase(): LiveData<String> {
        return repository.profileName
    }

    fun startNetworking() {
        _status.value = FirebaseResponseStatus.LOADING
        viewModelScope.launch(Dispatchers.IO) {
            provideName()
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
enum class FirebaseResponseStatus {
    LOADING, ERROR, DONE
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
