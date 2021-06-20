package com.template.user.service

import com.template.auth.tools.JwtTokenUtil
import com.template.common.function.FindUser
import com.template.domain.user.UserRepository
import com.template.user.dto.UserInfoResponseDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val jwtTokenUtil: JwtTokenUtil, private val userRepository: UserRepository, private val findUser: FindUser) {

    @Transactional(readOnly = true)
    fun getUserInfo(): UserInfoResponseDto {
        val user = findUser.get()
        return UserInfoResponseDto(user)
    }
}