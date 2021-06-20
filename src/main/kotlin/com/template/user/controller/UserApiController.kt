package com.template.user.controller

import com.template.user.dto.UserInfoResponseDto
import com.template.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserApiController(private val userService: UserService) {

    @GetMapping("/v1/user")
    fun getUserInfo(): UserInfoResponseDto {
        return userService.getUserInfo()
    }
}