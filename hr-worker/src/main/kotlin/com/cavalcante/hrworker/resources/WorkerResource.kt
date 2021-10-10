package com.cavalcante.hrworker.resources

import com.cavalcante.hrworker.entities.Worker
import com.cavalcante.hrworker.repositories.WorkerRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/workers")
class WorkerResource(private val workerRepository: WorkerRepository) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Worker>> {
        val response = workerRepository.findAll()
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Worker> {
        val response = workerRepository.findById(id).get()
        return ResponseEntity.ok(response)
    }

}