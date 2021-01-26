package com.example.jdaharis.data.remote

import android.util.Log
import com.example.jdaharis.data.remote.response.ContactResponse
import com.example.jdaharis.data.remote.response.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        private var results = "5"
        private var exc = "login,registered,i"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }

    }


    fun getAllContact(callback: LoadContactCallback) {

        val list = ArrayList<Results>()
        val client = ApiConfig.getApiService().getContact(
            results, exc)

        client.enqueue(object : Callback<ContactResponse> {
            override fun onResponse(call: Call<ContactResponse>, response: Response<ContactResponse>) {
                if (response.isSuccessful) {
                    Log.d("getMovie", "onresponse: ${response.body()}")
                    response.body()?.results.let { it?.let { it1 -> list.addAll(it1) } }
                    callback.onAllContactReceived(list)
                } else {
                    Log.e("getMovie", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ContactResponse>, t: Throwable) {
                Log.e("getMovie", "onFailure: ${t.message.toString()}")
            }

        })
    }


    interface LoadContactCallback {
        fun onAllContactReceived(movieResponse: List<Results>)
    }

}