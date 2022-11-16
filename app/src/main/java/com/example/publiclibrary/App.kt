package com.example.publiclibrary

import android.app.Application
import com.example.publiclibrary.data.di.ClientDataModule
import com.example.publiclibrary.domain.di.ClientDomainModule
import com.example.publiclibrary.presentation.di.ClientPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        ClientDomainModule.load()
        ClientDataModule.load()
        ClientPresentationModule.load()

    }
}