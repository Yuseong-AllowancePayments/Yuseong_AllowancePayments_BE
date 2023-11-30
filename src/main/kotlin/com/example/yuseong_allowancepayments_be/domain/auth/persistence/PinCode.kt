package com.example.yuseong_allowancepayments_be.domain.auth.persistence

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "tbl_pin_code")
class PinCode(
    @Id
    @Column(columnDefinition = "VARCHAR(6)", nullable = false)
    val code: String,

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    val centerName: String
)