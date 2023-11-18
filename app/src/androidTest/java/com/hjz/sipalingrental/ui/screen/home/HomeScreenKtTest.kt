package com.hjz.sipalingrental.ui.screen.home

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.hjz.sipalingrental.SiPalingRentalApp
import com.hjz.sipalingrental.ui.theme.SiPalingRentalTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeScreenKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            SiPalingRentalTheme {
                SiPalingRentalApp()
            }
        }
    }

    @Test
    fun test_search() {
        composeTestRule.onNodeWithText("Cari Tipe Mobil Rentalmu").performTextInput("Avanza")
        composeTestRule.onNodeWithText("Toyota Avanza").assertExists()
    }
}