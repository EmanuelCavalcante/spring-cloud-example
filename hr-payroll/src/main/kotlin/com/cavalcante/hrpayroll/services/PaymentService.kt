package com.cavalcante.hrpayroll.services

import com.cavalcante.hrpayroll.entities.Payment
import org.springframework.stereotype.Service

@Service
class PaymentService {

    fun getPayment(workId: Long, days: Int): Payment {
        return Payment("João", 200.0, days)
    }
}