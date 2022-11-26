package com.example.publiclibrary.domain

import com.example.publiclibrary.core.UseCase
import com.example.publiclibrary.data.model.Book
import com.example.publiclibrary.data.repositories.BookRepository
import kotlinx.coroutines.flow.Flow

class ListBookAllUseCase(private val repository: BookRepository)
    : UseCase<UseCase.None, List<Book>>() {
    override suspend fun execute(param: None): Flow<List<Book>> {
        return repository.listAllBooks()
    }
}