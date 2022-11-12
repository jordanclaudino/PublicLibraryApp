package com.example.publiclibrary.ui

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.publiclibrary.R
import com.example.publiclibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.btMenuClient.setOnClickListener {
            val intentClient = Intent(this,ClientActivity::class.java)
            startActivity(intentClient)
        }

        binding.btMenuBook.setOnClickListener {
            val intentBook = Intent(this,ClientActivity::class.java)
            startActivity(intentBook)
        }

        binding.btMenuLoan.setOnClickListener {
            val intentLoan = Intent(this, LoanActivity::class.java)
            startActivity(intentLoan)
        }
    }
}