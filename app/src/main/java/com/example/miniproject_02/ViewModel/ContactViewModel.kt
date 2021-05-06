package com.example.miniproject_02.ViewModel

import android.app.Application
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.miniproject_02.Model.AppDatabase
import com.example.miniproject_02.Model.Contact
import com.example.miniproject_02.Model.ContactRepository
import com.example.miniproject_02.View.Adapters.ContactRecyclerViewAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    var contacts = mutableListOf<Contact>()
    var myContacts: LiveData<MutableList<Contact>>
    var contactRepository: ContactRepository
    lateinit var app :Application
    val room: AppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "contacts").build()


    init {
        val contactDao = room.contactDao()
        contactRepository = ContactRepository(contactDao)
        myContacts = contactRepository.allContacts
    }




    fun addCase(contact: Contact){
        viewModelScope.launch (Dispatchers.IO){
            contactRepository.addContact(contact)
        }

    }

    fun delete(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            contactRepository.deleteContact(contact)
        }

    }

    fun updateContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            contactRepository.updateContact(contact)
        }
    }




}