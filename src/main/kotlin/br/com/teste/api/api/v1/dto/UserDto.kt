package br.com.teste.api.api.v1.dto

import br.com.teste.api.generics.GDto
import jakarta.validation.constraints.NotEmpty

data class UserDto(
    @NotEmpty val nome: String,
    @NotEmpty val login: String,
    @NotEmpty val senha: String
) :GDto<UserDto>
