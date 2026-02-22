package pl.dmardev172.hedgefirstapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.dmardev172.hedgefirstapp.screen.Screen
import pl.dmardev172.hedgefirstapp.ui.details.DetailsScreen
import pl.dmardev172.hedgefirstapp.ui.home.HomeScreen
import pl.dmardev172.hedgefirstapp.viewmodels.PostSharedViewModel

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val sharedViewModel: PostSharedViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                viewModel = sharedViewModel,
                onNavigateToDetails = { navController.navigate(Screen.Details.route) }
            )
        }

        composable(route = Screen.Details.route) {
//            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetailsScreen(
                viewModel = sharedViewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}