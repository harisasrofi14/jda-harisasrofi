package com.example.jdaharis.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.jdaharis.data.ContactRepository
import androidx.lifecycle.ViewModelProvider
import com.example.jdaharis.di.Injection
import com.example.jdaharis.ui.add.AddContactViewModel

class ViewModelFactory private constructor(private val mContactRepository: ContactRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AddContactViewModel::class.java) -> {
                AddContactViewModel(mContactRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}