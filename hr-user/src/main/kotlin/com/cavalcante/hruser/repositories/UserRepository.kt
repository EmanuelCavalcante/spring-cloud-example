package com.cavalcante.hruser.repositories

import com.cavalcante.hruser.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User
}