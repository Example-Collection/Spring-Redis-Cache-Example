package com.template.blog.controller

import com.template.blog.dto.BlogDetailResponseDto
import com.template.blog.service.BlogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BlogApiController(val blogService: BlogService) {


    @GetMapping("/v1/blog/{blogId}")
    fun getById(@PathVariable blogId: Int) : BlogDetailResponseDto {
        return blogService.getById(blogId)
    }
}