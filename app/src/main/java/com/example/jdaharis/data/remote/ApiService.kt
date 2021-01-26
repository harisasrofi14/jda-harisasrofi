package com.example.jdaharis.data.remote

import com.example.jdaharis.data.remote.response.ContactResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api")
    fun getContact(
        @Query("Results") results: String,
        @Query("exc") exc: String,
    ): Call<ContactResponse>
}