package com.example.yuseong_allowancepayments_be.domain.user.domain

import javax.persistence.*

@Entity
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(columnDefinition = "VARCHAR(20)")
    val accountId: String,

    @Column(columnDefinition = "VARCHAR(60)")
    val password: String
) {
}