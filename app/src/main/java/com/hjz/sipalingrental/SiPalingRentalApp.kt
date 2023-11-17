package com.hjz.sipalingrental

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hjz.sipalingrental.ui.components.BottomBar
import com.hjz.sipalingrental.ui.navigation.Screen
import com.hjz.sipalingrental.ui.screen.favorite.FavoriteScreen
import com.hjz.sipalingrental.ui.screen.home.HomeScreen
import com.hjz.sipalingrental.ui.screen.profile.ProfileScreen
import com.hjz.sipalingrental.ui.theme.SiPalingRentalTheme

@Composable
fun SiPalingRentalApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    //HomeScreen()
    Scaffold (
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Favorite.route) {
                FavoriteScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SiPalingRentalAppPreview() {
    SiPalingRentalTheme {
        SiPalingRentalApp()
    }
}