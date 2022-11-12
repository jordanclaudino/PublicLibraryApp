package com.example.publiclibrary.data.repositories.implementations

import android.os.RemoteException
import com.example.publiclibrary.data.repositories.BookRepository
import com.example.publiclibrary.data.services.BookServices
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class BookRepositoryImpl(private val service: BookServices) : BookRepository{
    override suspend fun listBooks(id: Long) = flow {
        try {
            val bookList = service.findById(id)
            emit(bookList)
        } catch (ex: HttpException){
            throw RemoteException(ex.message ?: "Não foi possível realizar a busca!")
        }
    }


}