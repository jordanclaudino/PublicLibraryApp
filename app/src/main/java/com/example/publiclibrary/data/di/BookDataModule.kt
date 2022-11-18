package com.example.publiclibrary.data.di

import android.util.Log
import com.example.publiclibrary.data.repositories.BookRepository
import com.example.publiclibrary.data.repositories.implementations.BookRepositoryImpl
import com.example.publiclibrary.data.services.BookServices
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BookDataModule {
    private const val OK_HTTP = "OkHttp"

    fun load(){
        loadKoinModules(networkModules() + booksModule())
    }

    private fun networkModules(): Module{
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
                createService<BookServices>(get(), get())
            }
        }
    }

    private fun booksModule(): Module {
        return module {
            single<BookRepository> { BookRepositoryImpl(get()) }
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