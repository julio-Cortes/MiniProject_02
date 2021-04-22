package com.example.miniproject_02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.google.android.material.textfield.TextInputEditText


class CreateContact : Fragment() {


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
            setFragmentResult("REQUEST", bundleOf("DATA" to Contact(nameInput.text.toString(),phoneInput.text.toString())))
            activity?.supportFragmentManager?.popBackStack()
        }
        return view
    }

}