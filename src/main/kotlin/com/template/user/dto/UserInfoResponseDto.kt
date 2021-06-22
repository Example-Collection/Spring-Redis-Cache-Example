package com.template.user.dto

import com.template.domain.user.User
import java.io.Serializable

data class UserInfoResponseDto(
    val userId: Int = 0,
    val name: String = "",
    val email: String = ""
) : Serializable {
    constructor(user: User) : this(user.id!!, user.name, user.email)
}