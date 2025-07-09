package dev.prateekthakur.dragonballencyclopedia.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.prateekthakur.dragonballencyclopedia.ui.screens.characters.CharactersPage
import dev.prateekthakur.dragonballencyclopedia.ui.screens.planets.PlanetsPage
import dev.prateekthakur.dragonballencyclopedia.ui.screens.settings.SettingsPage

@Composable
fun HomeNavbarNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = HomeNavbarRoute.Characters.route) {
        composable(HomeNavbarRoute.Planets.route){ PlanetsPage() }
        composable(HomeNavbarRoute.Characters.route){ CharactersPage() }
        composable(HomeNavbarRoute.Settings.route){ SettingsPage() }
    }
}