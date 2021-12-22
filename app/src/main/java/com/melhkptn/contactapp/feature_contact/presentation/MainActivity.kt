package com.melhkptn.contactapp.feature_contact.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.melhkptn.contactapp.R
import com.melhkptn.contactapp.feature_contact.domain.model.ContactItem
import com.melhkptn.contactapp.feature_contact.presentation.adapter.ContactAdapter
import com.melhkptn.contactapp.feature_contact.presentation.viewmodel.ContactViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ContactViewModel by viewModels()
    private var adapter = ContactAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.getContactList()

        viewModel.contactList.observe(this, Observer {
            val list = it
            adapter.updateContactList(list)
            lifecycleScope.launch {
                viewModel.addContactList(list)
            }
        })

        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {

            viewModel.addContact(ContactItem(
                "dasad",
                "sada",
                "dasda",
                "dsadadsda",
                "Melih",
                1,
                "dsadas",
                55
            ))
        }


    }


}