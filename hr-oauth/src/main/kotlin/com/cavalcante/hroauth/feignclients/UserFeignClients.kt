package com.cavalcante.hroauth.feignclients

import com.cavalcante.hroauth.entities.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Component
@FeignClient(name = "hr-user", path = "/users")
interface UserFeignClients {
    @GetMapping("/search")
    fun findByEmail(@RequestParam("email") email: String): ResponseEntity<User>
}