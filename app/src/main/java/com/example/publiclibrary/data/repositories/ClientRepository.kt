package com.example.publiclibrary.data.repositories

import com.example.publiclibrary.data.model.Client
import kotlinx.coroutines.flow.Flow

interface ClientRepository {
    suspend fun getClient (cpf : String): Flow<List<Client>>

    suspend fun listAllClient() : Flow<List<Client>>
}