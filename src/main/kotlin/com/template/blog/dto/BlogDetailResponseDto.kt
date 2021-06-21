package com.template.blog.dto

import com.template.domain.blog.Blog
import com.template.domain.blog.BlogType
import com.template.user.dto.UserInfoResponseDto
import java.time.LocalDateTime

data class BlogDetailResponseDto(
    val blogId: Int? = null,
    val title: String = "",
    val content: String = "",
    val createdAt: LocalDateTime? = null,
    val views: Int = -1,
    val type: BlogType = BlogType.GENERAL,
    val userInfo: UserInfoResponseDto? = null,
) {
    constructor(blog: Blog): this(
        blog.id,
        blog.title,
        blog.content,
        blog.createdAt,
        blog.views,
        blog.type,
        UserInfoResponseDto(blog.user),
    )
}