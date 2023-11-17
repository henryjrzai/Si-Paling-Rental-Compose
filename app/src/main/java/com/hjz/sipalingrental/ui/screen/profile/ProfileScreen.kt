package com.hjz.sipalingrental.ui.screen.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hjz.sipalingrental.R
import com.hjz.sipalingrental.ui.theme.SiPalingRentalTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.photo),
            contentDescription = "Photo Profile",
            modifier = modifier
                .size(200.dp)
                .border(
                    BorderStroke(4.dp, MaterialTheme.colorScheme.primary),
                    CircleShape
                )
                .padding(6.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Henry Junior Zai",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 26.sp,
            modifier = modifier
                .padding(4.dp)
        )
        Text (
            text = "Software Engineer Enthusiast",
            fontStyle = FontStyle.Italic,

        )
    }
}

@Preview (showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    SiPalingRentalTheme {
        ProfileScreen()
    }
}