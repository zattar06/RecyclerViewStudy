package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Create data class
        //Create list from data class type
        //Create Adapter
        //Set Adapter to RecyclerView
        //Linear Layout Manager
        //Submeter a lista

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val imageViewList = findViewById<ImageView>(R.id.imageView_list)
        val imageViewGrid = findViewById<ImageView>(R.id.imageView_grid)
        val adapter = ContactListAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        imageViewGrid.setOnClickListener {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }
        imageViewList.setOnClickListener {
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }
    }
}

val contacts = listOf(
    Contact(
        "John Doe", "1234567890", R.drawable.sample1
    ),
    Contact(
        "Jane Doe", "0987654321", R.drawable.sample2
    ),
    Contact(
        "John Smith", "1234567890", R.drawable.sample3
    ),
    Contact(
        "Jane Smith", "0987654321", R.drawable.sample4
    ),
    Contact(
        "John Johnson", "1234567890", R.drawable.sample5
    ),
    Contact(
        "Jane Johnson", "0987654321", R.drawable.sample6
    ),
    Contact(
        "John Brown", "1234567890", R.drawable.sample7
    ),
    Contact(
        "Jane Brown", "0987654321", R.drawable.sample8
    ),
    Contact(
        "John White", "1234567890", R.drawable.sample9
    ),
    Contact(
        "Jane White", "0987654321", R.drawable.sample10
    ),
    Contact(
        "John Black", "1234567890", R.drawable.sample11
    ),
    Contact(
        "Jane Black", "0987654321", R.drawable.sample12
    ),
    Contact(
        "John Green", "1234567890", R.drawable.sample13
    ),
    Contact(
        "Jane Green", "0987654321", R.drawable.sample14
    ),
    Contact(
        "John Blue", "1234567890", R.drawable.sample15
    ),
    Contact(
        "Jane Blue", "0987654321", R.drawable.sample16
    ),
)