package com.hjz.sipalingrental.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjz.sipalingrental.data.RentalCarRepository
import com.hjz.sipalingrental.model.OrderRentCar
import com.hjz.sipalingrental.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailScreenViewModel (
    private val repository: RentalCarRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderRentCar>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderRentCar>>
        get() = _uiState

    fun getRentCarById(id : String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderRentCar(id))
        }
    }
}