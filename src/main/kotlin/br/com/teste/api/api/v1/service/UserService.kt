package br.com.teste.api.api.v1.service

import br.com.teste.api.api.v1.dto.UserDto
import br.com.teste.api.api.v1.model.UserModel
import br.com.teste.api.dominio.User
import br.com.teste.api.generics.GDtoEntityMapper
import br.com.teste.api.generics.GEntityModelMapper
import br.com.teste.api.generics.GRepository
import br.com.teste.api.generics.GService
import org.springframework.stereotype.Service

@Service
class UserService(
    override var repository: GRepository<User>,
    override var dtoEntityMapper: GDtoEntityMapper<UserDto, User>,
    override var entityViewMapper: GEntityModelMapper<User, UserModel>
) : GService<User, UserDto, UserModel>()