package com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums

enum class AllowanceType(
    val fileName: String
) {
    WAR_VETERAN("참전명예수당 지급대상자"),
    WAR_VETERAN_SPOUSE("참전유공자 배우자수당 지급대상자"),
    HONORABLE_ALLOWANCE("보훈 예우수당 지급대상자");
}