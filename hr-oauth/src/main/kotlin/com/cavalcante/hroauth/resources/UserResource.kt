package com.cavalcante.hroauth.resources

import com.cavalcante.hroauth.entities.User
import com.cavalcante.hroauth.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserResource(private val userService: UserService) {
    @GetMapping("/search")
    fun findByEmail(@RequestParam("email") email: String): ResponseEntity<User?> {
        return try {
            val response = userService.findByEmail(email)
            ResponseEntity.ok(response)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}