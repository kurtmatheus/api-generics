package br.com.teste.api.api.v1.model

import br.com.teste.api.generics.GModel

data class UserModel(
    val id: Int,
    val nome: String,
    val login: String,
    val senha: String
) : GModel<UserModel>
