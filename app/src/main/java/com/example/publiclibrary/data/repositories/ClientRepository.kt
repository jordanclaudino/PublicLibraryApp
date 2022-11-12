package com.example.publiclibrary.data.repositories

import com.example.publiclibrary.data.model.Client
import kotlinx.coroutines.flow.Flow

interface ClientRepository {
    suspend fun listClient (user : String): Flow<List<Client>>
}