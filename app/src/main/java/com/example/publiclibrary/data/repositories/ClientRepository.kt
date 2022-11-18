package com.example.publiclibrary.data.repositories

import com.example.publiclibrary.data.model.Client
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

interface ClientRepository {
    suspend fun getClient (cpf : String): Flow<List<Client>>

    suspend fun listAllClient() : Flow<List<Client>>

    suspend fun addClient (jsonObject: JSONObject): Flow<Unit>
}