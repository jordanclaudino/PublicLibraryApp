package com.example.publiclibrary.domain


import com.example.publiclibrary.core.UseCase
import com.example.publiclibrary.data.repositories.ClientRepository
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject

class AddClientUseCase(private val repository: ClientRepository)
    : UseCase<JSONObject, Unit>(){
    override suspend fun execute(param: JSONObject): Flow<Unit> {
        return repository.addClient(param)
    }

}