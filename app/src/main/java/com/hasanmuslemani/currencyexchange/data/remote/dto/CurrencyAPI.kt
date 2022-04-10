package com.hasanmuslemani.currencyexchange.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyAPI {
    @GET("/{date}/{from}/{to}")
    suspend fun getCurrencyRate(@Path("from") from: String, @Path("to") to: String, @Path("date") date: String)
}