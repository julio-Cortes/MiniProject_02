package com.example.miniproject_02.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.miniproject_02.Model.Contact
import com.example.miniproject_02.R
import com.example.miniproject_02.ViewModel.ContactViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EditContact : Fragment() {

    val args : EditContactArgs by navArgs()
    private val viewModel: ContactViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edit_contact, container, false)
        val nameInput = view.findViewById<TextInputEditText>(R.id.name_input)
        nameInput.setText(args.contact.name.toString())
        val phoneInput = view.findViewById<TextInputEditText>(R.id.phone_input)
        phoneInput.setText(args.contact.phoneNumber.toString())
        val button = view.findViewById<Button>(R.id.save_button)
        val delete = view.findViewById<Button>(R.id.delete_button )
        button.setOnClickListener{
            viewModel.updateContact(Contact(args.contact.id,nameInput.text.toString(),phoneInput.text.toString()))

            findNavController().navigate(R.id.action_editContact_to_mainFragment)


        }
        delete.setOnClickListener{
            viewModel.delete(args.contact)
            findNavController().navigate(R.id.action_editContact_to_mainFragment)
        }
        return view
    }


}