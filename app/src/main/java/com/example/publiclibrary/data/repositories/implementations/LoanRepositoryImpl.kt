package com.example.publiclibrary.data.repositories.implementations

import android.os.RemoteException
import com.example.publiclibrary.data.model.Loan
import com.example.publiclibrary.data.repositories.LoanRepository
import com.example.publiclibrary.data.services.LoanServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class LoanRepositoryImpl(private val service: LoanServices): LoanRepository {
    override suspend fun listLoans() =  flow {
        try {
            val loanList = service.findAll()
            emit(loanList)
        } catch (ex: HttpException){
            throw RemoteException(ex.message ?: "Não foi possível realizar a busca!")
        }
    }

    override suspend fun addLoans(cpfClient: String, idBook: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun listLoansByCPF(cpfClient: String) = flow {
        try {
            val loanList = service.findByCpf(cpfClient)
            emit(loanList)
        } catch (ex: HttpException){
            throw RemoteException(ex.message ?: "Não foi possível realizar a busca!")
        }
    }

    override suspend fun listLoansByBook(idBook: Long) = flow {
        try {
            val loanList = service.findById(idBook)
            emit(loanList)
        } catch (ex: HttpException){
            throw RemoteException(ex.message ?: "Não foi possível realizar a busca!")
        }
    }

    override suspend fun listLoansById(id: Long) =  flow {
        try {
            val loanList = service.findById(id)
            emit(loanList)
        } catch (ex: HttpException){
            throw RemoteException(ex.message ?: "Não foi possível realizar a busca!")
        }
    }

    override suspend fun giveBack(id: Long) {
        TODO("Not yet implemented")
    }


}