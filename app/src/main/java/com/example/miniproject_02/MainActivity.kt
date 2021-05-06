package com.example.miniproject_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.add
import androidx.navigation.findNavController
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onSupportNavigateUp(): Boolean {
        val controller = findNavController(R.id.main_fragment)
        return controller.navigateUp() || super.onSupportNavigateUp()
    }
}

