package com.example.publiclibrary.data.repositories

import com.example.publiclibrary.data.model.Loan
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Path

interface LoanRepository {
    suspend fun listLoans(): Flow<List<Loan>>

    suspend fun addLoans(cpfClient: String, idBook: Long)

    suspend fun listLoansByCPF(cpfClient: String): Flow<List<Loan>>

    suspend fun listLoansByBook(idBook: Long): Flow<List<Loan>>

    suspend fun listLoansById(id: Long): Flow<List<Loan>>

    suspend fun giveBack(id: Long)
}
