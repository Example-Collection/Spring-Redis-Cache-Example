package com.template

import com.template.domain.user.User
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
@EnableJpaAuditing
class Application {
    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder(10)
    }

    @Bean
    fun userRedisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, User> {
        val redisTemplate = RedisTemplate<String, User>()
        redisTemplate.connectionFactory = redisConnectionFactory
        return redisTemplate
    }

}
fun main(args: Array<String>) {
    runApplication<Application>(*args)
}