package com.template.blog.service

import com.template.blog.dto.BlogDetailResponseDto
import com.template.blog.exception.BlogIdNotFoundException
import com.template.domain.blog.BlogRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BlogService(
    val blogRepository: BlogRepository
) {

    @Transactional(readOnly=true)
    fun getById(blogId: Int): BlogDetailResponseDto {
        val blog = blogRepository.findById(blogId).orElseThrow { BlogIdNotFoundException() }
        return BlogDetailResponseDto(blog)
    }

}