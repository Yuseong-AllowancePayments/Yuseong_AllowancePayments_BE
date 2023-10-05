package com.example.yuseong_allowancepayments_be.domain.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

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