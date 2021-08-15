package com.afdal.pua_3.repository.source.remoteDataSource

import androidx.lifecycle.LiveData

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