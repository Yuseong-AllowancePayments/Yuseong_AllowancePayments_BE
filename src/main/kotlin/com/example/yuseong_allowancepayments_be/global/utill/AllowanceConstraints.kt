package com.example.yuseong_allowancepayments_be.global.utill

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType.*

object AllowanceConstraints {
    val PAYMENT_TARGET_HEADER_ITEMS = listOf("연번", "행정동", "보훈번호", "성명", "주민등록번호", "주소", "입금유형", "은행명", "예금주", "계좌번호", "시비", "구비", "비고")
    val CASH_PAYMENT_HEADER_ITEMS = listOf("연번", "행정동", "보훈번호", "성명", "주민등록번호", "주소", "입금유형", "시비", "구비", "비고")
    fun NEWCOMER_HEADER_ITEMS(type: AllowanceType) =
        when (type) {
            WAR_VETERAN -> listOf("연번", "행정동", "보훈번호", "성명", "주민등록번호", "주소", "입금유형", "은행명", "예금주", "계좌번호", "전입일", "신청일", "신규사유", "비고")
            WAR_VETERAN_SPOUSE -> listOf("연번", "행정동", "신청자 성명", "신청자 주민등록번호", "신청자 전화번호", "참전유공자 성명", "참전유공자 주민등록번호", "보훈번호", "구분", "참전유공자 사망일자", "신청자 주소", "입금유형", "은행명", "예금주", "계좌번호", "전입일", "신청일", "신규사유", "비고")
            HONORABLE_ALLOWANCE -> listOf("연번", "행정동", "보훈번호", "신청자 성명", "신청자 주민등록번호", "보훈대상자 구분", "신청자 성별", "신청자 전화번호", "신청자 주소", "참전유공자 사망일자", "신청자 주소", "입금유형", "은행명", "예금주", "계좌번호", "가족관계", "선순위 유족 여부", "전입일", "신청일", "신규사유", "비고")
        }
    val PAYMENT_STOPPED_HEADER_ITEMS = listOf("연번", "행정동", "보훈번호", "성명", "주민등록번호", "주소", "입금유형", "은행명", "예금주", "계좌번호", "중단사유", "중단사유 발생일", "비고", "전입지 주소")
}