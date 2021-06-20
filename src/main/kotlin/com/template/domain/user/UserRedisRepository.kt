package com.template.domain.user

import com.template.user.dto.UserInfoResponseDto
import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRedisRepository(
    userRedisTemplate: RedisTemplate<String, User>
) {

    private var hashOperations: HashOperations<String, String, User>? = null

    init {
        hashOperations = userRedisTemplate.opsForHash()
    }

    fun save(user: User) {
        hashOperations?.put("USER", user.id!!.toString(), user)
    }

    fun findById(userId: Int): User? {
        return hashOperations?.get("USER", userId.toString())
    }
}