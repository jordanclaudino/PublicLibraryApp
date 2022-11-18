package com.example.publiclibrary.data.repositories.implementations

import android.os.RemoteException
import com.example.publiclibrary.data.repositories.ClientRepository
import com.example.publiclibrary.data.services.ClientServices
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
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

    override suspend fun listAllClient() = flow {
        try {
            val clientList = service.getAllClients()
            emit(clientList)
        } catch (ex: HttpException){
            throw RemoteException(ex.message ?: "Erro de Busca")
        }
    }

    override suspend fun addClient(jsonObject: JSONObject) =  flow {
        try {
            val addClient = service.addClient(jsonObject)
            emit(addClient)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Erro de Busca")
        }
    }


}