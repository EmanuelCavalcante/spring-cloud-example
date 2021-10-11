package com.cavalcante.hroauth.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore


@Configuration
class AppConfig {

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun accessTokenConverter(): JwtAccessTokenConverter? {
        val tokenConverter = JwtAccessTokenConverter()
        tokenConverter.setSigningKey("MY-SECRET-KEY")
        return tokenConverter
    }

    @Bean
    fun tokenStore(): JwtTokenStore? {
        return JwtTokenStore(accessTokenConverter())
    }
}