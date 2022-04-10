package com.hasanmuslemani.currencyexchange.data.remote

import com.hasanmuslemani.currencyexchange.data.remote.dto.ExchangeRateDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyAPI {
    @GET("/{date}/{from}/{to}")
    suspend fun getExchangeRate(@Path("from") from: String, @Path("to") to: String, @Path("date") date: String) : ExchangeRateDto
}