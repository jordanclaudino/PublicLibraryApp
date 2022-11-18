package com.example.publiclibrary.domain

import com.example.publiclibrary.core.UseCase
import com.example.publiclibrary.data.model.Client
import com.example.publiclibrary.data.repositories.ClientRepository
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject

class ListClientCpfUseCase(private val repository: ClientRepository)
    : UseCase<String, List<Client>>(){

    override suspend fun execute(param: String): Flow<List<Client>> {
        return repository.getClient(param)
    }
}