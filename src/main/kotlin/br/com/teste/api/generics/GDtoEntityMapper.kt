package br.com.teste.api.generics

import br.com.teste.api.util.Mapper

abstract class GDtoEntityMapper<T, U> : Mapper<T,U> {
    abstract override fun map(dto: T): U
}
