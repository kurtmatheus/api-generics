package br.com.teste.api.api.v1.dto

import br.com.teste.api.generics.GDtoEntityMapper
import org.springframework.stereotype.Component

@Component
class UserDtoEntityMapper : GDtoEntityMapper<UserDto, br.com.teste.api.dominio.User>() {
    override fun map(dto: UserDto): br.com.teste.api.dominio.User {
        return br.com.teste.api.dominio.User(
            nome = dto.nome,
            login = dto.login,
            senha = dto.senha
        )
    }
}