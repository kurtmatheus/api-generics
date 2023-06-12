package br.com.teste.api.api.v1.controller

import br.com.teste.api.api.v1.dto.UserDto
import br.com.teste.api.api.v1.model.UserModel
import br.com.teste.api.dominio.User
import br.com.teste.api.generics.GController
import br.com.teste.api.generics.GService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/users")
class UserController(
    override val service: GService<User, UserDto, UserModel>
) : GController<User, UserDto, UserModel>()