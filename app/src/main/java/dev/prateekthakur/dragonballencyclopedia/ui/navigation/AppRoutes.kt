package dev.prateekthakur.dragonballencyclopedia.ui.navigation

sealed class AppRoutes(val routeTemplate: String) {

    data object Home : AppRoutes("/")
    data object CharacterDetails: AppRoutes("character/{id}") {
        fun create(id: Int) = "character/$id"
    }
    data object PlanetDetails: AppRoutes("planet/{id}") {
        fun create(id: Int) = "planet/$id"
    }
}