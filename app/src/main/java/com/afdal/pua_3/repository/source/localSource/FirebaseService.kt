package com.afdal.pua_3.repository.source.localSource

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

object FirebaseService {
    private const val TAG = "FirebaseService"
    fun getDataUserName() {
        var mAuth = FirebaseAuth.getInstance()
        var db = FirebaseDatabase.getInstance().getReference("name")
        var listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d(TAG, snapshot.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d(TAG, error.message)
            }

        }
        db.addValueEventListener(listener)
    }
}