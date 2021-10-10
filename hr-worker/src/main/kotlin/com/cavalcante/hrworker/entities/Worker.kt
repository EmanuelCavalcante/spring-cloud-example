package com.cavalcante.hrworker.entities

import javax.persistence.*

@Entity
@Table(name = "TB_WORKER")
data class Worker(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val dailyIncome: Double,
)