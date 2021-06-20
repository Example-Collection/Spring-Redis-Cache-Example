package com.template.user.dto

import com.template.domain.user.User

data class UserInfoResponseDto(
    val userId: Int = 0,
    val name: String = "",
    val email: String = ""
) {
    constructor(user: User) : this(user.id!!, user.name, user.email)
}