package com.cavalcante.hrworker.repositories

import com.cavalcante.hrworker.entities.Worker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkerRepository : JpaRepository<Worker, Long> {
}