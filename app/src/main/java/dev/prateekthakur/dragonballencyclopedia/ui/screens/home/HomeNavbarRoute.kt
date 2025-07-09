package dev.prateekthakur.dragonballencyclopedia.ui.screens.home

import dev.prateekthakur.dragonballencyclopedia.R

sealed class HomeNavbarRoute(
    val route: String,
    val label: String,
    val icon: Int
){
    data object Characters : HomeNavbarRoute("characters", "Characters", R.drawable.character_icon)
    data object Planets : HomeNavbarRoute("planets", "Planets", R.drawable.planet_icon)
    data object Settings : HomeNavbarRoute("settings", "Settings", R.drawable.settings_icon)
}