package com.example.publiclibrary.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.publiclibrary.R
import com.example.publiclibrary.databinding.ActivityClientBinding
import com.example.publiclibrary.presentation.ClientViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClientActivity : AppCompatActivity() {
    private val viewModel by viewModel<ClientViewModel>()
    private val adapter by lazy { ClientListAdapter()}
    private val binding by lazy { ActivityClientBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}