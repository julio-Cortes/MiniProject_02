package com.example.miniproject_02.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.miniproject_02.Model.Contact
import com.example.miniproject_02.R
import com.example.miniproject_02.ViewModel.ContactViewModel
import com.google.android.material.textfield.TextInputEditText


class CreateContact : Fragment() {
    val args : CreateContactArgs by navArgs()
    private val viewModel: ContactViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_contact, container, false)
        val nameInput = view.findViewById<TextInputEditText>(R.id.name_input)
        val phoneInput = view.findViewById<TextInputEditText>(R.id.phone_input)
        val button = view.findViewById<Button>(R.id.save_button)

        button.setOnClickListener{

            viewModel.addCase(Contact(args.id+1,nameInput.text.toString(),phoneInput.text.toString()))

            findNavController().navigate(R.id.action_createContact_to_mainFragment)


        }
        return view
    }

}