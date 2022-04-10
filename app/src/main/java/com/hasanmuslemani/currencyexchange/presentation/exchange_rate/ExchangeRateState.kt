package com.hasanmuslemani.currencyexchange.presentation.exchange_rate

import com.hasanmuslemani.currencyexchange.domain.models.ExchangeRate

data class ExchangeRateState(
    val isLoading: Boolean = false,
    val exchangeRate: ExchangeRate? = null,
    val error: String = ""
)
