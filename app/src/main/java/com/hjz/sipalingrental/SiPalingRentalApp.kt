package com.hjz.sipalingrental

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hjz.sipalingrental.ui.home.HomeScreen
import com.hjz.sipalingrental.ui.theme.SiPalingRentalTheme

@Composable
fun SiPalingRentalApp(
    modifier: Modifier = Modifier,
) {
    HomeScreen()
}

@Preview(showBackground = true)
@Composable
fun SiPalingRentalAppPreview() {
    SiPalingRentalTheme {
        SiPalingRentalApp()
    }
}