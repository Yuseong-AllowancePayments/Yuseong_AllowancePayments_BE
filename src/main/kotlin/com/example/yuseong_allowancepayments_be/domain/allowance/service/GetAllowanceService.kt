package com.example.yuseong_allowancepayments_be.domain.allowance.service

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.CashPaymentStatusJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.GetAllowanceResponse
import org.springframework.stereotype.Service

@Service
class GetAllowanceService(
    private val cashPaymentStatusJpaRepository: CashPaymentStatusJpaRepository,
) {
    fun execute(type: AllowanceType): List<GetAllowanceResponse> {
        val cashPaymentStatusList =
            cashPaymentStatusJpaRepository.findByAllowanceTypeOrderBySerialNumberAsc(type)

        return cashPaymentStatusList.stream().map { it ->
            GetAllowanceResponse(
                id = it.id!!,
                serialNumber = it.serialNumber,
                haengJeongDong = it.hangJungDong,
                veteransNumber = it.veteransNumber,
                residentRegistrationNumber = it.residentRegistrationNumber,
                name = it.name,
                address = it.address,
                depositType = it.depositType,
                sibi = it.sibi,
                gubi = it.gubi,
                note = it.note,
                allowanceType = it.allowanceType,
            )
        }.toList()
    }
}