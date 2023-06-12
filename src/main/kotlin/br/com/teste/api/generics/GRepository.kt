package br.com.teste.api.generics

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface GRepository<E : GEntity<E>> : JpaRepository<E, Int>