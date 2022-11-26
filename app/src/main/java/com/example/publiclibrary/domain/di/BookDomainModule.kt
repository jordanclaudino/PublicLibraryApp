package com.example.publiclibrary.domain.di

import com.example.publiclibrary.domain.ListBookAllUseCase
import com.example.publiclibrary.domain.ListBookIdUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object BookDomainModule {

    fun load(){
        loadKoinModules(idUseCaseModule() + allUseCaseModule())
    }

    private fun idUseCaseModule() : Module {
        return module{
            factory { ListBookIdUseCase(get())}
        }
    }

    private fun allUseCaseModule(): Module {
        return module{
            factory { ListBookAllUseCase(get()) }
        }
    }

}