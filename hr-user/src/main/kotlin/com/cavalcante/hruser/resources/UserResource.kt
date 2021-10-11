package com.cavalcante.hruser.resources

import com.cavalcante.hruser.entities.User
import com.cavalcante.hruser.repositories.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserResource(private val userRepository: UserRepository) {


    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<User> {
        val response = userRepository.findById(id).get()
        return ResponseEntity.ok(response)
    }

    @GetMapping("/search")
    fun findByEmail(@RequestParam("email") email: String): ResponseEntity<User> {
        val response = userRepository.findByEmail(email)
        return ResponseEntity.ok(response)
    }
}