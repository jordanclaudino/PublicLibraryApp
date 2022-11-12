package com.example.publiclibrary.data.repositories

import com.example.publiclibrary.data.model.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun listBooks(id : Long): Flow<List<Book>>
}