package com.hjz.sipalingrental.model

data class RentalCar(
    val id : String,
    val rentalName : String,
    val typeCar : String,
    val location : String,
    val price : String,
    val description : String,
    val driver : String,
    val address : String,
    val imageUrl : String,
)
