package br.com.teste.api.generics

import br.com.teste.api.util.Mapper

abstract class GEntityModelMapper<T, U> : Mapper<T,U>{
    abstract override fun map(entity: T): U
}
