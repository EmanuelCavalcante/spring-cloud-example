package com.cavalcante.hrpayroll.services

import com.cavalcante.hrpayroll.entities.Payment
import com.cavalcante.hrpayroll.feignclients.WorkerFeignClient
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val workerFeignClient: WorkerFeignClient
) {

    fun getPayment(workId: Long, days: Int): Payment {
        val worker = workerFeignClient.findById(workId).body!!
        return Payment(worker.name, worker.dailyIncome, days)
    }
}