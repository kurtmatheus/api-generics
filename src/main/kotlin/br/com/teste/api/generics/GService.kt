package br.com.teste.api.generics

import jakarta.transaction.Transactional
import org.springframework.http.ResponseEntity
import org.springframework.web.util.UriComponentsBuilder
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.declaredMemberProperties

abstract class GService<E : GEntity<E>, D : GDto<D>, V : GModel<V>> {

    abstract var repository: GRepository<E>
    abstract var dtoEntityMapper: GDtoEntityMapper<D, E>
    abstract var entityViewMapper: GEntityModelMapper<E, V>

    private fun obter(id: Int): E = repository.getReferenceById(id)

    fun obterView(id: Int): V = mapearEntityView(obter(id))

    fun obterColecaoView() = repository.findAll().map { e ->
        entityViewMapper.map(e)
    }

    @Transactional
    open fun atualizar(dto: D, id: Int): ResponseEntity<V> {
        val update = obter(id)
        val override = mapearDtoEntity(dto)

        val kUpdateClass = update::class
        val kOverrideClass = override::class

        kOverrideClass.declaredMemberProperties
            .filter { it.name != "id" }
            .forEach { ofield ->
                val newValue = ofield.getter.call(override)

                val updateProperty = kUpdateClass.declaredMemberProperties.first {
                    it.name == ofield.name
                } as KMutableProperty<*>?

                updateProperty?.let {
                    updateProperty.setter.call(update, newValue)
                }
            }

        val newEntity = salvar(update)

        return ResponseEntity.ok(mapearEntityView(newEntity))
    }

    @Transactional
    fun criar(dto: D, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<V> {
        val entity = salvar(mapearDtoEntity(dto))
        val uri = uriComponentsBuilder.path("/api/v1/${obterNomeEntidade(entity)}/${entity.id}").build().toUri()
        return ResponseEntity.created(uri).body(mapearEntityView(entity))
    }

    private fun salvar(entity: E) = repository.save(entity)

    @Transactional
    fun deletar(id: Int) {
        obter(id)
        repository.deleteById(id)
    }

    protected fun mapearEntityView(entity: E) = entityViewMapper.map(entity)

    protected fun mapearDtoEntity(dto: D) = dtoEntityMapper.map(dto)

    private fun obterNomeEntidade(e: E): String {
        return "${e.javaClass.simpleName.lowercase()}s"
    }
}