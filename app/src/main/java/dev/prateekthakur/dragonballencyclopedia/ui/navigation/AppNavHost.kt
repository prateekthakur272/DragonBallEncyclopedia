package dev.prateekthakur.dragonballencyclopedia.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.prateekthakur.dragonballencyclopedia.ui.screens.characterdetails.CharacterDetailsScreen
import dev.prateekthakur.dragonballencyclopedia.ui.screens.home.HomeScreen
import dev.prateekthakur.dragonballencyclopedia.ui.screens.planetdetails.PlanetDetailsScreen

@SuppressLint("StaticFieldLeak")
lateinit var navController: NavHostController

@Composable
fun AppNavHost(controller: NavHostController = rememberNavController()) {
    navController = controller
    NavHost(navController = navController, startDestination = AppRoutes.Home.routeTemplate) {
        composable(AppRoutes.Home.routeTemplate) {
            HomeScreen()
        }
        composable(
            AppRoutes.CharacterDetails.routeTemplate,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            CharacterDetailsScreen()
        }
        composable(
            AppRoutes.PlanetDetails.routeTemplate,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            PlanetDetailsScreen()
        }
    }
}