package com.example.jdaharis.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jdaharis.data.remote.RemoteDataSource
import com.example.jdaharis.data.remote.response.Results
import com.example.jdaharis.ui.add.ContactEntity

class ContactRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    ContactDataSource {

    companion object{
        @Volatile
        private var instance: ContactRepository? = null
        fun getInstance(remoteDataSource: RemoteDataSource) : ContactRepository =
            instance ?: synchronized(this){
                instance ?: ContactRepository(remoteDataSource)
            }
    }

    override fun getAllContact(): LiveData<List<ContactEntity>> {
            val contactResults = MutableLiveData<List<ContactEntity>>()
        remoteDataSource.getAllContact(object : RemoteDataSource.LoadContactCallback{
            override fun onAllContactReceived(contactResponse: List<Results>) {
                val contactList = ArrayList<ContactEntity>()

                for (data in contactResponse) {
                    val contact = ContactEntity(
                        data.gender,
                        data.name,
                        data.location,
                        data.email,
                        data.dob,
                        data.phone,
                        data.cell,
                        data.id,
                        data.picture,
                        data.nat,
                    )
                    contactList.add(contact)
                }
                contactResults.postValue(contactList)
            }

        })
        return contactResults
    }
}