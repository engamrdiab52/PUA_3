package com.afdal.pua_3.repository.source.localSource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.afdal.pua_3.ui.FirebaseResponseStatus
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

object FirebaseService {
    val nameRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("name")
    private val _responseOfFirebase = MutableLiveData<String>()
    val responseOfFirebase: LiveData<String>
        get() = _responseOfFirebase

    //firebase response status
    private val _status = MutableLiveData<FirebaseResponseStatus>()
    val status: LiveData<FirebaseResponseStatus>
        get() = _status

    // Refresh
    suspend fun nameOfProfile() {

        try {
            val snapshot: DataSnapshot? = nameRef.get().await()
            _responseOfFirebase.postValue(snapshot?.value.toString())
            _status.postValue(FirebaseResponseStatus.DONE)
        } catch (e: Exception) {
            _responseOfFirebase.postValue(e.message)
            _status.postValue(FirebaseResponseStatus.ERROR)
        }
    }

}

