package com.hjz.sipalingrental

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hjz.sipalingrental.ui.components.BottomBar
import com.hjz.sipalingrental.ui.navigation.Screen
import com.hjz.sipalingrental.ui.screen.detail.DetailScreen
import com.hjz.sipalingrental.ui.screen.favorite.FavoriteScreen
import com.hjz.sipalingrental.ui.screen.home.HomeScreen
import com.hjz.sipalingrental.ui.screen.profile.ProfileScreen
import com.hjz.sipalingrental.ui.theme.SiPalingRentalTheme

@Composable
fun SiPalingRentalApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold (
        bottomBar = {
            if (currentRoute != Screen.DetailScreen.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = {
                        navController.navigate(Screen.DetailScreen.createRoute(it))
                    }
                )
            }
            composable(Screen.Favorite.route) {
                FavoriteScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                route = Screen.DetailScreen.route,
                arguments = listOf(navArgument("id"){ type = NavType.StringType})
            ) {
                val id = it.arguments?.getString("id") ?: ""
                DetailScreen(
                    id = id,
                    navigateBack = {
                        navController.navigateUp()
                    },
                )
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