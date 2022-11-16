package com.example.publiclibrary.data.repositories.implementations

import android.os.RemoteException
import com.example.publiclibrary.data.repositories.ClientRepository
import com.example.publiclibrary.data.services.ClientServices
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class ClientRepositoryImpl(private val service: ClientServices): ClientRepository {

    override suspend fun getClient(cpf: String) =  flow {
        try {
            val clientInfo = service.findByCPF(cpf)
            emit(clientInfo)
        } catch (ex: HttpException){
            throw RemoteException(ex.message ?: "Não foi possível realizar a busca!")
        }
    }

    override suspend fun listAllClient()= flow {
        try {
            val clientList = service.getAllClients()
            emit(clientList)
        } catch (ex: HttpException){
            throw RemoteException(ex.message ?: "Erro de Busca")
        }
    }


}