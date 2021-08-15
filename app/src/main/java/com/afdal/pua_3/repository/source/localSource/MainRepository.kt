package com.afdal.pua_3.repository.source.localSource

import androidx.lifecycle.LiveData
import com.afdal.pua_3.ui.FirebaseResponseStatus

class MainRepository {
    private val remoteDataSource = RemoteDataSource()
    suspend  fun provideName() {
        remoteDataSource.fetchName()
    }
    fun getResponseFirebase(): LiveData<String> {
        return remoteDataSource.getResponseFirebase()
    }
    val status : LiveData<FirebaseResponseStatus>
        get() = remoteDataSource.status
}
