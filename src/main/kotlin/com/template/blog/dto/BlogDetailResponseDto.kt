package com.template.blog.dto

import com.template.common.tools.DateConverter
import com.template.domain.blog.Blog
import com.template.domain.blog.BlogType
import com.template.user.dto.UserInfoResponseDto
import java.io.Serializable

data class BlogDetailResponseDto(
    val blogId: Int? = null,
    val title: String = "",
    val content: String = "",
    val createdAt: String? = null,
    val views: Int = -1,
    val type: BlogType = BlogType.GENERAL,
    val userInfo: UserInfoResponseDto? = null,
) : Serializable {
    constructor(blog: Blog): this(
        blog.id,
        blog.title,
        blog.content,
        DateConverter.convertDateWithTime(blog.createdAt!!),
        blog.views,
        blog.type,
        UserInfoResponseDto(blog.user),
    )
}