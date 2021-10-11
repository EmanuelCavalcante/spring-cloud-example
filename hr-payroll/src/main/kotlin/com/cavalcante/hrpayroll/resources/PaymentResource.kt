package com.cavalcante.hrpayroll.resources

import com.cavalcante.hrpayroll.entities.Payment
import com.cavalcante.hrpayroll.services.PaymentService
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
class PaymentResource(private val paymentService: PaymentService) {

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workId}/days/{days}")
    fun getPayment(
        @PathVariable("workId") workId: Long,
        @PathVariable(value = "workId") days: Int
    ): ResponseEntity<Payment> {
        val response = paymentService.getPayment(workId, days)
        return ResponseEntity.ok(response)
    }

    fun getPaymentAlternative(
        workId: Long,
        days: Int
    ): ResponseEntity<Payment> {
        return ResponseEntity.ok(Payment("Jose", 10.0, 10))
    }
}