package com.cavalcante.hroauth.entities

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import java.util.stream.Collectors


class User : UserDetails, Serializable {
    var id: Long? = null
    var name: String? = null
    var email: String? = null
    private var password: String? = null
    val roles: Set<Role> = HashSet()


    constructor(id: Long?, name: String?, email: String?, password: String?) : super() {
        this.id = id
        this.name = name
        this.email = email
        this.password = password
    }

    override fun getPassword(): String {
        return password!!
    }

    fun setPassword(password: String?) {
        this.password = password
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (id == null) 0 else id.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as User
        if (id == null) {
            if (other.id != null) return false
        } else if (id != other.id) return false
        return true
    }

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return roles.stream().map { (_, roleName): Role ->
            SimpleGrantedAuthority(
                roleName
            )
        }
            .collect(Collectors.toList())
    }

    override fun getUsername(): String {
        return email!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}