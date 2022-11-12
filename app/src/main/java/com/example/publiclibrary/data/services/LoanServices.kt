package com.example.publiclibrary.data.services

import com.example.publiclibrary.data.model.Loan
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface LoanServices {
    @POST("/emprestimo")
    suspend fun addLoan(cpfClient: String, idBook: Long)

    @GET("/emprestimo/{id}")
    suspend fun findById(@Path("id") id: Long): List<Loan>

    @GET("/emprestimo/livro/{idLivro}")
    suspend fun findByBook(@Path("idLivro") idBook: Long): List<Loan>

    @GET("/emprestimo/livro/{cpfCliente}")
    suspend fun findByCpf(@Path("cpfCliente") cpfClient: String): List<Loan>

    @PATCH("/emprestimo/devolver/{id}")
    suspend fun giveBack(@Path("id") id: Long)


}