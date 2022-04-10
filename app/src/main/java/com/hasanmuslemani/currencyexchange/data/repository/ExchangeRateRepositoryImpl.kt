package com.hasanmuslemani.currencyexchange.data.repository

import com.hasanmuslemani.currencyexchange.data.remote.CurrencyAPI
import com.hasanmuslemani.currencyexchange.data.remote.dto.ExchangeRateDto
import com.hasanmuslemani.currencyexchange.domain.repository.ExchangeRateRepository
import javax.inject.Inject

class ExchangeRateRepositoryImpl @Inject constructor(
    private val api: CurrencyAPI
) : ExchangeRateRepository {

    override suspend fun getExchangeRate(from: String, to: String, date: String): ExchangeRateDto {
        return api.getExchangeRate(from, to, date)
    }
}