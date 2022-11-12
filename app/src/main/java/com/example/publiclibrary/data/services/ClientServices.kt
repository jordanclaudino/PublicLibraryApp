package com.example.publiclibrary.data.services

import com.example.publiclibrary.data.model.Client
import retrofit2.http.*

interface ClientServices {
    @GET("/cliente/{cpf}")
    suspend fun findByCPF(@Path("cpf") cpf: String): List<Client>

    @PUT("/cliente/cpf")
    //TODO

    @POST("/cliente")
    suspend fun addClient()

    @DELETE("/cliente/delete/{cpf}")
    suspend fun deleteClient(@Path("cpf") cpf: String)


}