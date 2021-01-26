package com.example.jdaharis.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jdaharis.R
import com.example.jdaharis.viewmodel.ViewModelFactory
import com.example.jdaharis.ui.add.AddContactActivity.*

class AddContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this,factory)[AddContactViewModel::class.java]

        viewModel.getContact().observe(this, Observer { contact ->

        })
    }
}