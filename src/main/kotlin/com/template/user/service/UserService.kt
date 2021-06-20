package com.template.user.service

import com.template.auth.tools.JwtTokenUtil
import com.template.domain.user.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val jwtTokenUtil: JwtTokenUtil, private val userRepository: UserRepository) {

    @Transactional(readOnly = true)
    fun getUserInfo(dto)
}