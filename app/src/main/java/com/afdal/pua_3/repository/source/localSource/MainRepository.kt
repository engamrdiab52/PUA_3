package com.afdal.pua_3.repository.source.localSource

import androidx.lifecycle.LiveData
import com.afdal.pua_3.ui.FirebaseResponseStatus

class MainRepository {
    private val remoteDataSource = RemoteDataSource()

    // firebase response status error or Done
    val status: LiveData<FirebaseResponseStatus>
        get() = remoteDataSource.status

    // Refresh
    suspend fun provideName() {
        remoteDataSource.fetchName()
    }

    //profile name
    val profileName : LiveData<String>
    get() = remoteDataSource.getResponseFirebase()

    /*fun getResponseFirebase(): LiveData<String> {
        return
    }*/

}
