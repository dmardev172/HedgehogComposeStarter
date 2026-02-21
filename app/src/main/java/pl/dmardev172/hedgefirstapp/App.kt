package pl.dmardev172.hedgefirstapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToDetails = { id ->
                    navController.navigate(Screen.Details.createRoute(id))
                }
            )
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetailsScreen(id = id, onBack = { navController.popBackStack() })
        }
    }
}