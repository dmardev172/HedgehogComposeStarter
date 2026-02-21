package pl.dmardev172.hedgefirstapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.dmardev172.hedgefirstapp.screen.DetailsScreen
import pl.dmardev172.hedgefirstapp.screen.HomeScreen
import pl.dmardev172.hedgefirstapp.screen.Screen

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen { navController.navigate(Screen.Details.route) } }
        composable(Screen.Details.route) { DetailsScreen { navController.popBackStack() } }
    }
}