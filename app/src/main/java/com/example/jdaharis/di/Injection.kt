package com.example.jdaharis.di

import android.content.Context
import com.example.jdaharis.data.ContactRepository
import com.example.jdaharis.data.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): ContactRepository {
        val remoteDataSource = RemoteDataSource.getInstance()

        return ContactRepository.getInstance(remoteDataSource)
    }
}