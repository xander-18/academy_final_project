 package com.example.myxapp

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myxapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

 class MainActivity : AppCompatActivity() {


     private val items = arrayOf("Plastico", "Organico", "Agrarios", "Domesticos")
     private lateinit var autoCompleteTextView: AutoCompleteTextView
     private lateinit var adapterItems: ArrayAdapter<String>
     private lateinit var binding: ActivityMainBinding

     override fun onCreate(savedInstanceState: Bundle   ?) {
         super.onCreate(savedInstanceState)
         enableEdgeToEdge()

         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)


         autoCompleteTextView = findViewById(R.id.autoCompleteTextView)
         adapterItems = ArrayAdapter(this, R.layout.list_item, items)

         autoCompleteTextView.setAdapter(adapterItems)

         autoCompleteTextView.onItemClickListener =
             AdapterView.OnItemClickListener { parent, view, position, id ->
                 val item = parent.getItemAtPosition(position).toString()
             }

         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
             val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
             insets
         }

         val navView: BottomNavigationView = binding.navView
         val navController = findNavController(R.id.nav_host_fragment_activity_main)
         navView.setupWithNavController(navController)
     }
 }