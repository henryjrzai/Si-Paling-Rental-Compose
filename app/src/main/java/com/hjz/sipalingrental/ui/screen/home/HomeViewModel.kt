package com.hjz.sipalingrental.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hjz.sipalingrental.data.RentalCarRepository
import com.hjz.sipalingrental.model.RentalCar
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel (private val repository : RentalCarRepository) : ViewModel() {
    private val _groupedRentalCars = MutableStateFlow(
        repository.getRentalCar()
            .sortedBy { it.rentalName }
            .groupBy { it.rentalName[0] }
    )

    val groupedRentalCars: StateFlow<Map<Char, List<RentalCar>>> get() = _groupedRentalCars

    private val _query = mutableStateOf("")
    val query : State<String> get() = _query

    fun searcRent(newQuery: String) {
        _query.value = newQuery
        _groupedRentalCars.value = repository.searchRentCar(_query.value)
            .sortedBy { it.rentalName }
            .groupBy { it.rentalName[0] }
    }
}

class ViewModelFactory(private val repository: RentalCarRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}