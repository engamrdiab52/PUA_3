package com.afdal.pua_3.repository.source.remoteDataSource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.afdal.pua_3.repository.UserProfile
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

object FirebaseService {
    val nameRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("profiles").child("JRB3ZofURqdUHJ5xlY3aOua14ti1")
    private val _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile>
        get() = _userProfile

    //firebase response status
    private val _status = MutableLiveData<FirebaseResponseStatus>()
    val status: LiveData<FirebaseResponseStatus>
        get() = _status

    // Refresh
    suspend fun nameOfProfile() {
        _status.postValue( FirebaseResponseStatus.LOADING)
        try {
            val snapshot: DataSnapshot? = nameRef.get().await()
            _userProfile.postValue(snapshot?.getValue(UserProfile::class.java))
            _status.postValue(FirebaseResponseStatus.DONE)
        } catch (e: Exception) {
           // _responseOfFirebase.postValue(e.message)
            _status.postValue(FirebaseResponseStatus.ERROR)
        }
    }

}
enum class FirebaseResponseStatus {
    LOADING, ERROR, DONE
}

