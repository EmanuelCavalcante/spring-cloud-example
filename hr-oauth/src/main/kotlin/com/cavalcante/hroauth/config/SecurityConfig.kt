package com.cavalcante.hroauth.config

import com.cavalcante.hroauth.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Configuration
class SecurityConfig(
    private val userDetailsService: UserDetailsService,
    private val passwordEncoder: BCryptPasswordEncoder
) :
    WebSecurityConfigurerAdapter() {

    @Autowired
    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder)
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManager(): AuthenticationManager? {
        return super.authenticationManager()
    }

}