package com.example.publiclibrary.domain.di

import com.example.publiclibrary.domain.ListClientAllUseCase
import com.example.publiclibrary.domain.ListClientCpfUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object ClientDomainModule {

    fun load(){
        loadKoinModules(cpfUseCaseModule() + allUseCaseModele())
    }

    private fun cpfUseCaseModule(): Module {
        return module {
            factory { ListClientCpfUseCase(get())}
        }
    }

    private fun allUseCaseModele(): Module{
        return module {
            factory { ListClientAllUseCase(get()) }
        }
    }
}