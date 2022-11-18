package com.example.publiclibrary.domain.di

import com.example.publiclibrary.domain.AddClientUseCase
import com.example.publiclibrary.domain.ListClientAllUseCase
import com.example.publiclibrary.domain.ListClientCpfUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object ClientDomainModule {

    fun load(){
        loadKoinModules(cpfUseCaseModule() + allUseCaseModule() + addUseCaseModule())
    }

    private fun cpfUseCaseModule(): Module {
        return module {
            factory { ListClientCpfUseCase(get())}
        }
    }

    private fun allUseCaseModule(): Module{
        return module {
            factory { ListClientAllUseCase(get()) }
        }
    }

    private fun addUseCaseModule(): Module{
        return module {
            factory { AddClientUseCase(get()) }
        }
    }

}