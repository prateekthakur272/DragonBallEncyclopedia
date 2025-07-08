package dev.prateekthakur.dragonballencyclopedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import dev.prateekthakur.dragonballencyclopedia.ui.screens.home.HomeScreen
import dev.prateekthakur.dragonballencyclopedia.ui.theme.DragonBallEncyclopediaTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DragonBallEncyclopediaTheme(dynamicColor = false) {
                HomeScreen()
            }
        }
    }
}
