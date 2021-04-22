package com.example.miniproject_02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment(),OnClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter:ContactRecyclerViewAdapter
    private val viewModel: ContactViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main,container, false)
        recyclerView = view.findViewById(R.id.contact_recycler_view)
        adapter = ContactRecyclerViewAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val addContactButton = view.findViewById<Button>(R.id.add_contact_button)

        viewModel.myContacts.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter.refreshContacts(it)
        })

        addContactButton.setOnClickListener{
            val bundle = Bundle()
            val fragmentTwo = CreateContact()
            fragmentTwo.arguments = bundle
            setFragmentResultListener("REQUEST"){ requestKey: String, bundle: Bundle ->
                if (requestKey == "REQUEST") {
                    val result = bundle.get("DATA")
                    viewModel.addCase(result as Contact)
                }
            }
            activity?.supportFragmentManager?.commit {
                this.replace(R.id.main_fragment, fragmentTwo)
                this.addToBackStack(null)
            }
        }


        return view
    }

    override fun onClickItem(item: Any) {
        println("ola")
        //TODO("Not yet implemented")
    }

    override fun onDestroy() {
        viewModel.save()
        super.onDestroy()
    }


}






