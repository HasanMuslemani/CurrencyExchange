package com.hasanmuslemani.currencyexchange.di

import com.hasanmuslemani.currencyexchange.common.Constants
import com.hasanmuslemani.currencyexchange.data.remote.CurrencyAPI
import com.hasanmuslemani.currencyexchange.data.repository.ExchangeRateRepositoryImpl
import com.hasanmuslemani.currencyexchange.domain.repository.ExchangeRateRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCurrencyAPI() : CurrencyAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideExchangeRateRepository(api: CurrencyAPI) : ExchangeRateRepository {
        return ExchangeRateRepositoryImpl(api)
    }
}