package com.example.publiclibrary.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.publiclibrary.R
import com.example.publiclibrary.core.createDialog
import com.example.publiclibrary.core.createProgressDialog
import com.example.publiclibrary.data.di.ClientDataModule
import com.example.publiclibrary.databinding.ActivityMainBinding
import com.example.publiclibrary.domain.di.ClientDomainModule
import com.example.publiclibrary.presentation.di.ClientPresentationModule

class MainActivity : AppCompatActivity() {

    private val dialog by lazy { createProgressDialog()}
    private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btMenuClient.setOnClickListener {
            val intentClient = Intent(this,ClientActivity::class.java)
            startActivity(intentClient)
        }

        binding.btMenuBook.setOnClickListener {
            val intentBook = Intent(this,BookActivity::class.java)
            startActivity(intentBook)
        }

        binding.btMenuLoan.setOnClickListener {
            val intentLoan = Intent(this, LoanActivity::class.java)
            startActivity(intentLoan)
        }

        binding.btMenuAbout.setOnClickListener {
            createDialog{
                setMessage("Aplicativo criado para aumentar o portifólio, ainda em andamento")
            }.show()
        }
    }
}