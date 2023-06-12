package br.com.teste.api.exceptions.view

data class ErrorView(
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)