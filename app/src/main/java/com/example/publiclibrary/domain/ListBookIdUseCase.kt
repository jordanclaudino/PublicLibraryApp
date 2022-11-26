package com.example.publiclibrary.domain

import com.example.publiclibrary.core.UseCase
import com.example.publiclibrary.data.model.Book
import com.example.publiclibrary.data.repositories.BookRepository
import kotlinx.coroutines.flow.Flow

class ListBookIdUseCase(private val repository: BookRepository)
    : UseCase<Long, List<Book>>() {
    override suspend fun execute(param: Long): Flow<List<Book>> {
        return repository.listBooks(param)
    }

}