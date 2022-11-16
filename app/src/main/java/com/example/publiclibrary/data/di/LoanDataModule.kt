package com.example.publiclibrary.data.di

import android.util.Log
import com.example.publiclibrary.data.repositories.ClientRepository
import com.example.publiclibrary.data.repositories.LoanRepository
import com.example.publiclibrary.data.repositories.implementations.ClientRepositoryImpl
import com.example.publiclibrary.data.repositories.implementations.LoanRepositoryImpl
import com.example.publiclibrary.data.services.ClientServices
import com.example.publiclibrary.data.services.LoanServices
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoanDataModule {

    private const val OK_HTTP = "OkHttp"

    fun load(){
        loadKoinModules(networkModules() + repositoriesModule())
    }

    private fun networkModules(): Module {
        return module {
            single {
                val interceptor = HttpLoggingInterceptor{
                    Log.e(OK_HTTP, it)
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            }

            single {
                GsonConverterFactory.create(GsonBuilder().create())
            }

            single {
                createService<LoanServices>(get(), get())
            }
        }
    }

    private fun repositoriesModule(): Module {
        return module {
            single<LoanRepository> { LoanRepositoryImpl(get()) }
        }
    }

    private inline fun <reified T> createService(client: OkHttpClient, factory: GsonConverterFactory) : T{
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080")
            .client(client)
            .addConverterFactory(factory)
            .build().create(T::class.java)
    }
}