package com.hasanmuslemani.currencyexchange.data.remote.dto

import com.hasanmuslemani.currencyexchange.domain.models.ExchangeRate

data class ExchangeRateDto(
    val rate: Double
)

fun ExchangeRateDto.toExchangeRate() : ExchangeRate {
    return ExchangeRate(rate)
}