package com.hasanmuslemani.currencyexchange.presentation.exchange_rate

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.hasanmuslemani.currencyexchange.common.Constants
import com.hasanmuslemani.currencyexchange.common.Resource
import com.hasanmuslemani.currencyexchange.domain.use_case.get_exchange_rate.GetExchangeRateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ExchangeRateViewModel @Inject constructor(
    private val getExchRateUseCase: GetExchangeRateUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(ExchangeRateState())
    val state: State<ExchangeRateState> = _state

    private fun getExchangeRate(from: String, to: String, date: String) {
        getExchRateUseCase(from, to, date).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = ExchangeRateState(exchangeRate = result.data)
                }
                is Resource.Error -> {
                    _state.value = ExchangeRateState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = ExchangeRateState(isLoading = true)
                }
            }
        }
    }
}