package com.example.publiclibrary.data.model

data class Client(
    val cpf: String,
    val nome: String,
    val endereco: Adress
){
    override fun toString(): String {
        return "CPF: $cpf \n" +
                "Nome: $nome \n\n" +
                "Endereço: $endereco"
    }
}
