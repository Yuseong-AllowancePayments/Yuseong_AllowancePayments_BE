package com.example.yuseong_allowancepayments_be.domain.auth.service

import com.example.yuseong_allowancepayments_be.domain.auth.dto.IssuePinCodeRequest
import com.example.yuseong_allowancepayments_be.domain.auth.exception.PinCodeAlreadyExistsException
import com.example.yuseong_allowancepayments_be.domain.auth.persistence.PinCode
import com.example.yuseong_allowancepayments_be.domain.auth.persistence.repository.PinCodeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class IssuePinCodeService(
    private val pinCodeRepository: PinCodeRepository
) {

    fun execute(request: IssuePinCodeRequest) {
        if (pinCodeRepository.existsByCenterName(request.centerName)) {
            throw PinCodeAlreadyExistsException
        }

        pinCodeRepository.save(
            PinCode(
                code = (Random().nextInt(899999) + 100000).toString(),
                centerName = request.centerName
            )
        )
    }
}