package com.example.miniproject_02.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miniproject_02.Model.Contact
import com.example.miniproject_02.Interfaces.OnClickListener
import com.example.miniproject_02.R
import com.example.miniproject_02.View.Adapters.ContactRecyclerViewAdapter
import com.example.miniproject_02.ViewModel.ContactViewModel

class MainFragment : Fragment(), OnClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ContactRecyclerViewAdapter
    private val viewModel: ContactViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        recyclerView = view.findViewById(R.id.contact_recycler_view)
        adapter = ContactRecyclerViewAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel.myContacts.observe(this, Observer {  contact ->
            adapter.refreshContacts(contact)
        })

        val addContactButton = view.findViewById<Button>(R.id.add_contact_button)
        addContactButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToCreateContact(adapter.itemCount)
            Navigation.findNavController(view).navigate(action)
            adapter.notifyDataSetChanged()

        }
        Toast.makeText(context,"to delete swipe right", Toast.LENGTH_SHORT)

        return view
    }




    override fun onClickItem(item: Any, position: Int) {
        val action = MainFragmentDirections.actionMainFragmentToEditContact(item as Contact)
        view?.let { Navigation.findNavController(it).navigate(action) }

    }







}






