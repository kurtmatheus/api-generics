package br.com.teste.api.dominio

import br.com.teste.api.generics.GEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Int? = null,
    val nome: String,
    val login: String,
    val senha: String
) : GEntity<User>