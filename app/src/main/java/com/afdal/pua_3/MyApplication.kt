package com.afdal.pua_3

import android.app.Application
import com.afdal.pua_3.repository.MainRepository
import com.afdal.pua_3.repository.source.ServiceLocator
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MyApplication : Application() {
    val repository: MainRepository
        get() = ServiceLocator.provideMainRepository()

    override fun onCreate() {
        super.onCreate()
        Firebase.database.setPersistenceEnabled(true)
    }
}