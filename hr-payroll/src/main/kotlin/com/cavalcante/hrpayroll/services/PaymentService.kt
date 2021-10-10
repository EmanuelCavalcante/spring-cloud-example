package com.cavalcante.hrpayroll.services

import com.cavalcante.hrpayroll.entities.Payment
import com.cavalcante.hrpayroll.entities.Worker
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PaymentService(
    private val restTemplate: RestTemplate,
    @Value("\${hr-worker.host}") private val hrWorkerHost: String
) {

    fun getPayment(workId: Long, days: Int): Payment {
        val worker = restTemplate.getForObject("$hrWorkerHost/$workId", Worker::class.java)!!
        return Payment(worker.name, worker.dailyIncome, days)
    }
}