package com.hjz.sipalingrental.di

import com.hjz.sipalingrental.data.RentalCarRepository

object Injection {
    fun provideRepository(): RentalCarRepository {
        return RentalCarRepository.getInstance()
    }
}