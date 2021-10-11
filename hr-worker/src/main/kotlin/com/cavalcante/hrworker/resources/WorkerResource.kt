package com.cavalcante.hrworker.resources

import com.cavalcante.hrworker.entities.Worker
import com.cavalcante.hrworker.repositories.WorkerRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@RefreshScope
@RestController
@RequestMapping("/workers")
class WorkerResource(
    private val workerRepository: WorkerRepository,
    private val env: Environment,
    @Value("\${test.config}") private val testConfig: String
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Worker>> {
        val response = workerRepository.findAll()
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Worker> {
        println("port=${env["local.server.port"]}")
        val response = workerRepository.findById(id).get()
        return ResponseEntity.ok(response)
    }

    @GetMapping("/configs")
    fun getConfigs(): ResponseEntity<Void> {
        println("Test config: $testConfig")
        return ResponseEntity.noContent().build()
    }

}