package com.example.jdaharis.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jdaharis.data.ContactRepository

class AddContactViewModel(private val contactRepository: ContactRepository) : ViewModel() {
    fun getContact(): LiveData<List<ContactEntity>> = contactRepository.getAllContact()
}