package com.example.publiclibrary.data.services


import com.example.publiclibrary.data.model.Adress
import com.example.publiclibrary.data.model.Client
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface ClientServices {
    @GET("/cliente")
    suspend fun getAllClients (): List<Client>

    @GET("/cliente/{cpf}")
    suspend fun findByCPF(@Path("cpf") cpf: String): List<Client>

    @PUT("/cliente/cpf")
    //TODO

    @POST("/cliente/create")
    suspend fun addClient(jsonObject: JSONObject)
}