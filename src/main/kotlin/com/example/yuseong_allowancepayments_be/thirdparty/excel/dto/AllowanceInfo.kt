package com.example.yuseong_allowancepayments_be.thirdparty.excel.dto

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.CashPaymentStatus
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.Newcomer
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.PaymentStopped
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.PaymentTarget

data class AllowanceInfo(
    val paymentTargets: List<PaymentTarget>,
    val cashPayments: List<CashPaymentStatus>,
    val newcomers: List<Newcomer>,
    val paymentStopped: List<PaymentStopped>
)