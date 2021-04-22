package com.example.miniproject_02

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.File
import java.io.FileWriter
import java.io.InputStreamReader
import java.lang.Exception

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    var contacts = mutableListOf<Contact>()
    val myContacts = MutableLiveData<MutableList<Contact>>()
    lateinit var app :Application

    init {
        val f = "contacts.txt"

        try {

            val fileObject = application.baseContext.openFileInput(f)
            val input = InputStreamReader(fileObject)
            val buffer = BufferedReader(input)
            var text:String? = null
            while ({text = buffer.readLine();text}()!=null){

                if (text!=null)
                {
                    val sub_text = text!!.split(";")!!.toTypedArray()
                    contacts.add(Contact(sub_text[0],sub_text[1]))
                }

            }
            this.myContacts.postValue(contacts)
        }
        catch (e :Exception)
        {
            println(e.message)
            println("help")
        }

        this.myContacts.postValue(contacts)


    }
    fun addCase(contact: Contact){
        contacts.add(contact)
        this.myContacts.postValue(contacts)
    }
    fun save(){
        app = getApplication<Application>().applicationContext as Application
        var file = app.baseContext.openFileOutput("contacts.txt", Context.MODE_PRIVATE)
        for (con in contacts)
        {
            file.write((con.name+";"+con.phoneNumber+"\n").toByteArray())
        }
        file.close()
    }


}