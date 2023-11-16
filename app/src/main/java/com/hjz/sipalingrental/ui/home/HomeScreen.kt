@file:OptIn(ExperimentalFoundationApi::class)

package com.hjz.sipalingrental.ui.home

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hjz.sipalingrental.data.RentalCarRepository
import com.hjz.sipalingrental.ui.components.CardListItem
import com.hjz.sipalingrental.ui.components.Search
import com.hjz.sipalingrental.ui.theme.SiPalingRentalTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = ViewModelFactory(RentalCarRepository()))
) {
    val groupedRentalCars by viewModel.groupedRentalCars.collectAsState()
    val query by viewModel.query

    Box(modifier = modifier) {
        LazyColumn (
            modifier = modifier
                .padding(8.dp)
        ) {
            item {
                Search(
                    query = query,
                    onQueryChange = viewModel::searcRent,
                )
            }
            groupedRentalCars.forEach { (initial, rentalCar) ->
                items(rentalCar, key = { it.id }) { data ->
                    CardListItem(
                        rentalName = data.rentalName,
                        typeCar = data.typeCar,
                        location = data.location,
                        imageUrl = data.imageUrl,
                        modifier = Modifier
                            .animateItemPlacement(tween(durationMillis = 100))
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    SiPalingRentalTheme {
        HomeScreen()
    }
}