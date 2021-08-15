package com.afdal.pua_3.repository.source

import com.afdal.pua_3.repository.MainRepository
import com.afdal.pua_3.repository.source.remoteDataSource.RemoteDataSource


object ServiceLocator {
    @Volatile
    private var repository: MainRepository? = null

    fun provideMainRepository(): MainRepository {
        synchronized(this) {
            return repository ?: createRepository()
        }
    }

    private fun createRepository(): MainRepository {
        val remoteDataSource = RemoteDataSource()
        val newRepo = MainRepository(remoteDataSource)
        repository = newRepo
        return newRepo
    }

}