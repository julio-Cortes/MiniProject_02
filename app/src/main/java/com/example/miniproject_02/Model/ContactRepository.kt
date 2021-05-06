package com.example.miniproject_02.Model

import androidx.lifecycle.LiveData

class ContactRepository(private val contactDao :ContactDao) {
    val allContacts: LiveData<MutableList<Contact>> = contactDao.getAll()

    suspend fun addContact(contact:Contact)
    {
        contactDao.insert(contact)
    }

    suspend fun deleteContact(contact: Contact) {
        contactDao.delete(contact)
    }

    suspend fun updateContact(contact: Contact) {
        contactDao.update(contact)

    }
}