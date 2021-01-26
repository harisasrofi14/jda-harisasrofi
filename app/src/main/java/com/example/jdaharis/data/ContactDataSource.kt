package com.example.jdaharis.data

import androidx.lifecycle.LiveData
import com.example.jdaharis.ui.add.ContactEntity

interface ContactDataSource {
    fun getAllContact(): LiveData<List<ContactEntity>>
}