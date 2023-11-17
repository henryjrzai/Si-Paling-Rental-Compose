package com.hjz.sipalingrental.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.hjz.sipalingrental.R
import com.hjz.sipalingrental.di.Injection
import com.hjz.sipalingrental.ui.common.UiState
import com.hjz.sipalingrental.ui.screen.home.ViewModelFactory
import com.hjz.sipalingrental.ui.theme.SiPalingRentalTheme

@Composable
fun DetailScreen(
    id: String,
    viewModel : DetailScreenViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
    navigateBack: () -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading)
        .value.let {
            when (it) {
                is UiState.Loading -> {
                    viewModel.getRentCarById(id)
                }
                is UiState.Success -> {
                    val data = it.data
                    DetailContent(
                        imageUrl = data.rentCar.imageUrl,
                        typeCar = data.rentCar.typeCar,
                        price = data.rentCar.price,
                        rentalName = data.rentCar.rentalName,
                        location = data.rentCar.location,
                        driver = data.rentCar.driver,
                        description = data.rentCar.description,
                        address = data.rentCar.address,
                        onBackClick = navigateBack
                    )
                }
                is UiState.Error -> { }
            }
        }
}

@Composable
fun DetailContent(
    imageUrl : String,
    typeCar : String,
    price : String,
    rentalName : String,
    location : String,
    driver : String,
    description : String,
    address : String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isFavoriteState by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
    ) {
        Box {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.back),
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.DarkGray, RoundedCornerShape(10.dp))
                    .clickable { onBackClick() },
                tint = Color.White
            )
        }
        Column (
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = typeCar,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp
            )
            Text(
                text = rentalName,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp
            )
            Row {
                Icon(
                    Icons.Filled.LocationOn,
                    contentDescription = null
                )
               Text(
                   text = location
               )
            }
            Row (
                modifier = modifier
                    .padding(vertical = 10.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.price),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = price,
                    )
                }
            }
            Row (
                modifier = modifier
                    .padding(vertical = 10.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.description),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = description,
                    )
                }
            }
            Row (
                modifier = modifier
                    .padding(vertical = 10.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.driver),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = driver,
                    )
                }
            }
            Row (
                modifier = modifier
                    .padding(vertical = 10.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.address),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = address,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    SiPalingRentalTheme {
        DetailContent(
            imageUrl = "https://www.griyamobilkita.com/wp-content/uploads/2010/07/12032008652.jpg",
            typeCar = "Toyota Avanza",
            price = "Rp 250.000/hari",
            rentalName = "Bima Rent Car",
            location = "Jakarta Selatan",
            driver = "Tersedia (biaya tambahan Rp 100.000/hari)",
            description = "Mobil keluarga 7 penumpang yang sangat nyaman untuk perjalanan jarak jauh maupun dekat. Dilengkapi fitur AC, sound system, tempat duduk yang leluasa, bagasi luas, dan performa mesin yang tangguh dan irit bahan bakar. Ideal untuk liburan bersama keluarga besar.",
            address = "Bima Rent Car - Jl. Panjang No.55 Kebayoran Baru",
            onBackClick = { }
        )
    }
}