package com.hjz.sipalingrental

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.hjz.sipalingrental.model.RentalCarData
import com.hjz.sipalingrental.ui.navigation.Screen
import com.hjz.sipalingrental.ui.theme.SiPalingRentalTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SiPalingRentalAppTest{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            SiPalingRentalTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                SiPalingRentalApp(navController = navController)
            }
        }
    }

    @Test
    fun navHost_verifyStartDestination() {
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_clickItem_navigatesToDetailWithData() {
        composeTestRule.onNodeWithTag("RentalCarList").performScrollToIndex(5)
        composeTestRule.onNodeWithText(RentalCarData.rental[5].rentalName).performClick()
        navController.assertCurrentRouteName(Screen.DetailScreen.route)
        composeTestRule.onNodeWithText(RentalCarData.rental[5].rentalName).assertIsDisplayed()
    }

    @Test
    fun navHost_clickItem_navigatesBack() {
        composeTestRule.onNodeWithTag("RentalCarList").performScrollToIndex(10)
        composeTestRule.onNodeWithText(RentalCarData.rental[5].rentalName).performClick()
        navController.assertCurrentRouteName(Screen.DetailScreen.route)
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.back)).performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
    }
}