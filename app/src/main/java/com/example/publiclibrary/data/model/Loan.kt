package com.example.publiclibrary.data.model

data class Loan(
    val id: Long,
    val cliente: Client,
    val livro: Book,
    val loanDate: String,
    val giveBackDate: String,
    val status: String
)
