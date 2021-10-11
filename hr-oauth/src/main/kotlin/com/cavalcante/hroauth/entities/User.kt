package com.cavalcante.hroauth.entities

data class User(
    val id: Long? = null,
    val name: String? = null,
    val email: String? = null,
    val password: String? = null,
    val roles: Set<Role>? = null
)