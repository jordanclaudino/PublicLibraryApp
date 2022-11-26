package com.example.publiclibrary.presentation.di

import com.example.publiclibrary.presentation.BookViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object BookPresentationModule {

    fun load(){
        loadKoinModules(bookViewModelModule())
    }

    private fun bookViewModelModule(): Module{
        return module {
            viewModel { BookViewModel(get(), get()) }
        }
    }
}