package com.afdal.pua_3.repository.source.localSource

import androidx.lifecycle.LiveData
import com.afdal.pua_3.ui.FirebaseResponseStatus

class RemoteDataSource {

   suspend fun fetchName(){
        FirebaseService.nameOfProfile()
    }
    fun getResponseFirebase(): LiveData<String> {
        return FirebaseService.responseOfFirebase
    }
    val status : LiveData<FirebaseResponseStatus>
    get() = FirebaseService.status
}