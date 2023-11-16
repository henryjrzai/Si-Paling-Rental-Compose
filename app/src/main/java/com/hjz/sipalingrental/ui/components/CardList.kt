package com.hjz.sipalingrental.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hjz.sipalingrental.ui.theme.SiPalingRentalTheme

@Composable
fun CardListItem(
    rentalName : String,
    typeCar : String,
    location : String,
    imageUrl : String,
    modifier: Modifier = Modifier
) {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        modifier = modifier
            .clickable {}
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = modifier
                    .padding(horizontal = 8.dp)
                    .size(120.dp)
            )
            Column (
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxHeight()
            ) {
                Text(
                    text = typeCar,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )
                Row {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = null
                    )
                    Text(
                        text = rentalName,
                        fontStyle = FontStyle.Italic,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                }
                Row {
                    Icon(
                        Icons.Filled.LocationOn,
                        contentDescription = null
                    )
                    Text(
                        text = location,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardListItemPreview() {
    SiPalingRentalTheme {
        CardListItem(
            "Bima Rent Car",
            "Toyota Avanza",
            "Jakarta Selatan",
            "https://www.griyamobilkita.com/wp-content/uploads/2010/07/12032008652.jpg"
        )
    }
}