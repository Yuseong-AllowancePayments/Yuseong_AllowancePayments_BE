package com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType

data class GetAllowanceResponse(
    val id: Long,
    val serialNumber: Int,
    val haengJeongDong: String,
    val veteransNumber: String,
    val residentRegistrationNumber: String,
    val name: String,
    val address: String,
    val depositType: String,
    val sibi: Int,
    val gubi: Int,
    val note: String,
    val allowanceType: AllowanceType,
)
