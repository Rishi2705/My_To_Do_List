package com.example.my_to_do_list

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_to_do_list.Data.newtasklist
import com.example.my_to_do_list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),TasksAdapter.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    var adapter: TasksAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.addbtn.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }

        val data = Task(intent.getStringExtra("task")?:"")
        if (data.text.isNotEmpty()) {
            newtasklist.add(data)
        }

        binding.recycle.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        adapter = TasksAdapter(this, newtasklist,this)
        binding.recycle.adapter = adapter
    }
    override fun onClick(data: Task) {
        super.onClick(data)
        Toast.makeText(this,"Deletind",Toast.LENGTH_SHORT).show()
        newtasklist.remove(data)
    }
}