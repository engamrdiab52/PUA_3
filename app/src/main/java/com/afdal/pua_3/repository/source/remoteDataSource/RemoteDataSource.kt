package com.afdal.pua_3.repository.source.remoteDataSource

import androidx.lifecycle.LiveData
import com.afdal.pua_3.repository.UserProfile

class RemoteDataSource {

   suspend fun fetchName(){
       FirebaseService.nameOfProfile()
    }
    fun getResponseFirebase(): LiveData<UserProfile> {
        return FirebaseService.userProfile
    }
    val status : LiveData<FirebaseResponseStatus>
    get() = FirebaseService.status
}