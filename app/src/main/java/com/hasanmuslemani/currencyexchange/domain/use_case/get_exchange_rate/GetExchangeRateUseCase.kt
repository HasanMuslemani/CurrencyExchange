package com.hasanmuslemani.currencyexchange.domain.use_case.get_exchange_rate

import com.hasanmuslemani.currencyexchange.common.Resource
import com.hasanmuslemani.currencyexchange.data.remote.dto.toExchangeRate
import com.hasanmuslemani.currencyexchange.domain.models.ExchangeRate
import com.hasanmuslemani.currencyexchange.domain.repository.ExchangeRateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetExchangeRateUseCase @Inject constructor(
    private val repository: ExchangeRateRepository
){
    operator fun invoke(from: String, to: String, date: String): Flow<Resource<ExchangeRate>> = flow {
        try {
            emit(Resource.Loading())
            val exchangeRate = repository.getExchangeRate(from, to, date).toExchangeRate()
            emit(Resource.Success(exchangeRate))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error("Please check your internet connection and try again"))
        }
    }
}