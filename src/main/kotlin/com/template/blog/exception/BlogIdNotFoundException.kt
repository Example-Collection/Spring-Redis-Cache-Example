package com.template.blog.exception

import com.template.common.exception.NotFoundException

class BlogIdNotFoundException: NotFoundException {
    constructor(message: String): super(message)
    constructor(): super("blogId is invalid.")
}