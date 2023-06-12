package br.com.teste.api.util

interface Mapper<k,v> {
    fun map(entity: k): v
}