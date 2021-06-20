package com.template.domain.user

import com.template.user.dto.UserInfoResponseDto
import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRedisRepository(
    userRedisTemplate: RedisTemplate<String, UserInfoResponseDto>
) {

    private var hashOperations: HashOperations<String, String, UserInfoResponseDto>? = null

    init {
        hashOperations = userRedisTemplate.opsForHash()
    }

    fun save(dto: UserInfoResponseDto) {
        hashOperations?.put("USER", dto.userId.toString(), dto)
    }

    fun findById(userId: Int): UserInfoResponseDto? {
        return hashOperations?.get("USER", userId.toString())
    }
}