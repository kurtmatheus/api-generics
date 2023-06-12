package br.com.teste.api.exceptions

class EntidadeInexistenteException(
    s: String,
    e: RuntimeException? = null
) : RuntimeException(s, e)
