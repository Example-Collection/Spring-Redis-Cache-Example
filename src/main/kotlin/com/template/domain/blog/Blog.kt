package com.template.domain.blog

import com.template.domain.common.CreatedAtEntity
import com.template.domain.user.User
import javax.persistence.*

@Entity
@Table(name = "blogs")
class Blog(title: String, content: String, type: BlogType, user: User) : CreatedAtEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "blog_id")
    val id: Int? = null

    @Column(nullable = false, length = 300)
    var title: String = title

    @Column(nullable = false)
    var content: String = content

    @Column(nullable = false)
    var views: Int = 0

    @Column(nullable = false, name = "blog_type")
    @Enumerated(EnumType.STRING)
    var type: BlogType = type

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User = user
}