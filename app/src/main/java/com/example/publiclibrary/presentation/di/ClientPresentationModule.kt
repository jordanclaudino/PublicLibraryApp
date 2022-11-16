package com.example.publiclibrary.presentation.di

import com.example.publiclibrary.presentation.ClientViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object ClientPresentationModule {

    fun load(){
        loadKoinModules(viewModelModule())
    }

    private fun viewModelModule(): Module {
        return module {
            viewModel { ClientViewModel(get(), get()) }
        }

    }
}