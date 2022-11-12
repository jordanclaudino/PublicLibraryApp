package com.example.publiclibrary.data.repositories

import com.example.publiclibrary.data.model.Loan
import kotlinx.coroutines.flow.Flow

interface LoanRepository {
    suspend fun listLoans(user : String): Flow<List<Loan>>
}