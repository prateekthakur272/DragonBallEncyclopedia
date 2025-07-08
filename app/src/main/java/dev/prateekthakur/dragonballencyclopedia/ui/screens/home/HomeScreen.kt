package dev.prateekthakur.dragonballencyclopedia.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.prateekthakur.dragonballencyclopedia.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val navBarItems = listOf(
        HomeNavbarRoute.Characters,
        HomeNavbarRoute.Planets
    )

    val bottomNavBar = @Composable {
        NavigationBar(
            tonalElevation = 0.dp
        ){
            navBarItems.map {
                val currentDestination = navController.currentBackStackEntryAsState().value?.destination
                val selected = currentDestination?.route == it.route
                NavigationBarItem(
                    icon = { Icon(painter = painterResource(it.icon), contentDescription = it.label, modifier = modifier.size(24.dp)) },
                    label = { Text(it.label) },
                    onClick = {
                        if (!selected) {
                            navController.navigate(it.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    selected = selected,
                    colors = NavigationBarItemColors(
                        selectedIconColor = MaterialTheme.colorScheme.surface,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedTextColor = MaterialTheme.colorScheme.primary,
                        disabledIconColor = MaterialTheme.colorScheme.primary,
                        disabledTextColor = MaterialTheme.colorScheme.primary,
                        selectedIndicatorColor = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }

    val appBar = @Composable {
        TopAppBar(
            title = {
                Text(text = stringResource(R.string.full_app_name), style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary))
            }
        )
    }

    Scaffold(
        topBar = appBar,
        bottomBar = bottomNavBar
    ) { scaffoldPadding ->
        Box(modifier = modifier.padding(scaffoldPadding)) {
            HomeNavbarNavHost(navController)
        }
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}