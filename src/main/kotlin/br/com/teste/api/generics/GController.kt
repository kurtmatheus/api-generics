package br.com.teste.api.generics

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

abstract class GController<T : GEntity<T>, D : GDto<D>, V : GModel<V>> {

    abstract val service: GService<T, D, V>

    @GetMapping
    fun obterColecao() = service.obterColecaoView()

    @GetMapping("/{id}")
    fun obter(@PathVariable id: Int): ResponseEntity<V> {
        return ResponseEntity.ok(service.obterView(id))
    }

    @PostMapping
    fun inserir(@RequestBody @Valid dto: D, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<V> {
        return service.criar(dto, uriComponentsBuilder)
    }

    @PutMapping("/{id}")
    fun atualizar(@RequestBody @Valid dto: D, @PathVariable id: Int): ResponseEntity<V> {
        return service.atualizar(dto, id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Int) = service.deletar(id)
}