package com.hjz.sipalingrental

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.hjz.sipalingrental.ui.theme.SiPalingRentalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SiPalingRentalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SiPalingRentalApp()
                }
            }
        }
    }
}
