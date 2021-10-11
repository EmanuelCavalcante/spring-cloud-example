package com.cavalcante.hruser.entities

import javax.persistence.*


@Entity
@Table(name = "tb_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String? = null,
    val email: String? = null,
    val password: String? = null,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "tb_user_role",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    val roles: Set<Role>? = null
)