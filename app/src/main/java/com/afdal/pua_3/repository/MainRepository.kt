package com.afdal.pua_3.repository

import androidx.lifecycle.LiveData
import com.afdal.pua_3.repository.source.remoteDataSource.RemoteDataSource
import com.afdal.pua_3.ui.FirebaseResponseStatus

class MainRepository(private val remoteDataSource: RemoteDataSource) {

    //profile name
    val profileName: LiveData<String>
        get() = remoteDataSource.getResponseFirebase()

    // firebase response status error or Done
    val firebaseResponseStatus: LiveData<FirebaseResponseStatus>
        get() = remoteDataSource.status

    // Refresh
    suspend fun refreshProfile() {
        remoteDataSource.fetchName()
    }


}
