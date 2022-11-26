package com.example.publiclibrary.data.services

import com.example.publiclibrary.data.model.Book
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BookServices {
    @GET("/livro/{id}")
    suspend fun findById(@Path("id") id: Long): List<Book>

    @POST("/livro")
    suspend fun addBook(isbn: Long)

    @GET("/livro")
    suspend fun getAllBooks(): List<Book>
}