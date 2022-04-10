package com.hasanmuslemani.currencyexchange.domain.repository

import com.hasanmuslemani.currencyexchange.data.remote.dto.ExchangeRateDto

interface ExchangeRateRepository {
    suspend fun getExchangeRate(from: String, to: String, date: String): ExchangeRateDto
}