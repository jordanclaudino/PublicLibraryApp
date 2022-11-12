package com.example.publiclibrary.data.repositories.implementations

import android.os.RemoteException
import com.example.publiclibrary.data.repositories.ClientRepository
import com.example.publiclibrary.data.services.ClientServices
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class ClientRepositoryImpl(private val service: ClientServices): ClientRepository {
    override suspend fun listClient(cpf: String) =  flow {
        try {
            val clientList = service.findByCPF(cpf)
            emit(clientList)
        } catch (ex: HttpException){
            throw RemoteException(ex.message ?: "Não foi possível realizar a busca!")
        }
    }

}