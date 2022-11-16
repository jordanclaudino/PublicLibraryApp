package com.example.publiclibrary.domain

import com.example.publiclibrary.core.UseCase
import com.example.publiclibrary.data.model.Client
import com.example.publiclibrary.data.repositories.ClientRepository
import kotlinx.coroutines.flow.Flow

class ListClientAllUseCase(private val repository: ClientRepository)
    : UseCase<UseCase.None, List<Client>>() {
    override suspend fun execute(param: None): Flow<List<Client>> {
        return repository.listAllClient()
    }
}