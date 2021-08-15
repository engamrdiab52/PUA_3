package com.afdal.pua_3.repository

import androidx.lifecycle.LiveData
import com.afdal.pua_3.repository.source.remoteDataSource.FirebaseResponseStatus
import com.afdal.pua_3.repository.source.remoteDataSource.RemoteDataSource


class MainRepository(private val remoteDataSource: RemoteDataSource) {

    //profile name
    val profileName: LiveData<String>
        get() = remoteDataSource.getResponseFirebase()

    // firebase response status error or Done ,need it for binding adapter
    val firebaseResponseStatus: LiveData<FirebaseResponseStatus>
        get() = remoteDataSource.status

    // Refresh
    suspend fun refreshProfile() {
        remoteDataSource.fetchName()
    }


}
