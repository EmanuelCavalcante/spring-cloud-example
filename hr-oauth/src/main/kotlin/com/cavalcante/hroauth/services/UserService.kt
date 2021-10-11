package com.cavalcante.hroauth.services

import com.cavalcante.hroauth.entities.User
import com.cavalcante.hroauth.feignclients.UserFeignClients
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class UserService(private val userFeignClients: UserFeignClients) : UserDetailsService {
    fun findByEmail(email: String): User {
        userFeignClients.findByEmail(email).body?.let {
            return it
        } ?: run {
            throw IllegalArgumentException("Email not found")
        }
    }

    override fun loadUserByUsername(email: String): UserDetails {
        userFeignClients.findByEmail(email).body?.let {
            return it
        } ?: run {
            throw UsernameNotFoundException("Email not found")
        }
    }
}