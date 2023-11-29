package com.example.yuseong_allowancepayments_be.thirdparty.excel.dto

import com.example.yuseong_allowancepayments_be.domain.allowance.domain.CashPaymentStatus
import com.example.yuseong_allowancepayments_be.domain.allowance.domain.Newcomer
import com.example.yuseong_allowancepayments_be.domain.allowance.domain.PaymentStopped
import com.example.yuseong_allowancepayments_be.domain.allowance.domain.PaymentTarget

data class AllowanceInfo(
    val paymentTargets: List<PaymentTarget>,
    val cashPayments: List<CashPaymentStatus>,
    val newcomers: List<Newcomer>,
    val paymentStopped: List<PaymentStopped>
)