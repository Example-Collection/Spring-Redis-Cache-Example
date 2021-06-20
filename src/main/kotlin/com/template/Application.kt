package com.template

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import redis.clients.jedis.Jedis
import java.time.Duration

@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
class Application {
    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder(10)
    }

    @Bean
    fun cacheConfiguration(): RedisCacheConfiguration {
        return RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(60)) // 1시간의 TTL 지정
            .disableCachingNullValues()  // Null 값에 대한 caching disable
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(GenericJackson2JsonRedisSerializer()))
    }

    @Bean
    fun redisCacheManagerBuilder(): RedisCacheManagerBuilderCustomizer {
        return RedisCacheManagerBuilderCustomizer { builder ->
            builder.withCacheConfiguration("userCache", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)))
        }
    }

    @Bean
    fun jedis(): Jedis {
        return Jedis()
    }
}
fun main(args: Array<String>) {
    runApplication<Application>(*args)
}