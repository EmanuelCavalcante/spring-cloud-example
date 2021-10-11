package com.cavalcante.hroauth.services

import com.cavalcante.hroauth.entities.User
import com.cavalcante.hroauth.feignclients.UserFeignClients
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class UserService(private val userFeignClients: UserFeignClients) {
    fun findByEmail(email: String): User {
        userFeignClients.findByEmail(email).body?.let {
            return it
        } ?: run {
            throw IllegalArgumentException("Email not found")
        }
    }
}