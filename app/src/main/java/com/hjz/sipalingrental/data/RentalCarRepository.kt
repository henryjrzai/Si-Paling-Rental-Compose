package com.hjz.sipalingrental.data

import com.hjz.sipalingrental.model.RentalCar
import com.hjz.sipalingrental.model.RentalCarData

class RentalCarRepository {
    fun getRentalCar() : List<RentalCar> {
        return RentalCarData.rental
    }

    fun searchRentCar(query: String): List<RentalCar>{
        return RentalCarData.rental.filter {
            it.typeCar.contains(query, ignoreCase = true)
        }
    }
}