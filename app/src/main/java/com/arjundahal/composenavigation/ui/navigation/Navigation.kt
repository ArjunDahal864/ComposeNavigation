package com.arjundahal.composenavigation.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.*
import androidx.compose.material.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.arjundahal.composenavigation.ui.screens.DocumentScreen
import com.arjundahal.composenavigation.ui.screens.HomeScreen
import com.arjundahal.composenavigation.ui.screens.ProfileScreen
import com.arjundahal.composenavigation.ui.screens.SearchScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val screens = listOf(
        Screen.HomePage,
        Screen.SearchPage,
        Screen.Document,
        Screen.Profile
    )

    Scaffold(bottomBar = {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        BottomNavigation {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            screens.forEach { screen ->
                BottomNavigationItem(
                    icon = { Icon(screen.icon, contentDescription = null) },
                    label = { Text(stringResource(screen.resourceId)) },
                    enabled = true,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    alwaysShowLabel = true,
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                )
            }

        }
    }) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.HomePage.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Screen.HomePage.route) { HomeScreen(navController = navController) }
            composable(Screen.SearchPage.route) { SearchScreen(navController = navController) }
            composable(Screen.Document.route) { DocumentScreen(navController = navController) }
            composable(Screen.Profile.route) { ProfileScreen(navController = navController) }
        }


    }


}
