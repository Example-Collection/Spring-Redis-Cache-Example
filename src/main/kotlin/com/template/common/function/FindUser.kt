package com.template.common.function

import com.template.auth.exception.UserUnAuthorizedException
import com.template.domain.user.User
import com.template.domain.user.UserRedisRepository
import com.template.domain.user.UserRepository
import com.template.security.service.UserDetailsImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.function.Supplier

@Component
class FindUser : Supplier<User> {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userRedisRepository: UserRedisRepository

    override fun get(): User {
        val userId = Integer.parseInt((SecurityContextHolder.getContext().authentication.principal as UserDetailsImpl).username)
        val cachedUser = userRedisRepository.findById(userId)
        print(cachedUser)
        return if(cachedUser == null) {
            val user = userRepository.findById(userId).orElseThrow { UserUnAuthorizedException() }
            userRedisRepository.save(user)
            user
        } else cachedUser
    }
}