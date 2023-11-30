package com.example.yuseong_allowancepayments_be.domain.auth.service

import com.example.yuseong_allowancepayments_be.domain.auth.dto.GetCenterPinCodesResponse
import com.example.yuseong_allowancepayments_be.domain.auth.dto.PinCodeResponse
import com.example.yuseong_allowancepayments_be.domain.auth.persistence.repository.PinCodeRepository
import org.springframework.stereotype.Service

@Service
class GetCenterPinCodesService(
    private val pinCodeRepository: PinCodeRepository
) {
    fun execute(): GetCenterPinCodesResponse {
        val pinCodes = pinCodeRepository.findAll()

        return GetCenterPinCodesResponse(
            pinCodes.map {
                PinCodeResponse(
                    code = it.code,
                    centerName = it.centerName
                )
            }
        )
    }
}