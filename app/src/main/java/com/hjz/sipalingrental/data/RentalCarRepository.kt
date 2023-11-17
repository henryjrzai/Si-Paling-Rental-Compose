package com.hjz.sipalingrental.data

import com.hjz.sipalingrental.model.OrderRentCar
import com.hjz.sipalingrental.model.RentalCar
import com.hjz.sipalingrental.model.RentalCarData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class RentalCarRepository {

    private val rentCar = mutableListOf<OrderRentCar>()

    init {
        if (rentCar.isEmpty()) {
            RentalCarData.rental.forEach {
                rentCar.add(OrderRentCar(it,0))
            }
        }
    }

    fun getRentCar () : Flow<List<OrderRentCar>> = flowOf(rentCar)

    fun getRentalCar() : List<RentalCar> {
        return RentalCarData.rental
    }

    fun searchRentCar(query: String): List<RentalCar>{
        return RentalCarData.rental.filter {
            it.typeCar.contains(query, ignoreCase = true)
        }
    }

    companion object {
        @Volatile
        private var instance: RentalCarRepository? = null

        fun getInstance(): RentalCarRepository =
            instance ?: synchronized(this) {
                RentalCarRepository().apply {
                    instance = this
                }
            }
    }
}