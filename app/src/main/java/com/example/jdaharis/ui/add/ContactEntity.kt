package com.example.jdaharis.ui.add

import com.example.jdaharis.data.remote.response.*

data class ContactEntity (
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val dob: Dob,
    val phone: Int,
    val cell: Int,
    val id: Id,
    val picture: Picture,
    val nat: String
    )