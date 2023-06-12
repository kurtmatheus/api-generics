package br.com.teste.api.api.v1.model

import br.com.teste.api.dominio.User
import br.com.teste.api.generics.GEntityModelMapper
import org.springframework.stereotype.Component

@Component
class UserEntityModelMapper : GEntityModelMapper<User, UserModel>() {
    override fun map(entity: User): UserModel {
        return UserModel(
            id = entity.id ?: 0,
            nome = entity.nome,
            login = entity.login,
            senha = entity.senha
        )
    }
}
