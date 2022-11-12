package com.example.publiclibrary.data.repositories

import com.example.publiclibrary.data.model.Adress
import kotlinx.coroutines.flow.Flow

interface AdressRepository {
    suspend fun listAdress(cep : String): Flow<List<Adress>>
}