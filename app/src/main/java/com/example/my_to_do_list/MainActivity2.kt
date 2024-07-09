package com.example.my_to_do_list

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.my_to_do_list.databinding.ActivityMain2Binding
import com.example.my_to_do_list.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.addbtn.setOnClickListener {
            val task = binding.newTask.text.toString()
            startActivity(Intent(this,MainActivity::class.java).putExtra("task",task))
        }

    }
}