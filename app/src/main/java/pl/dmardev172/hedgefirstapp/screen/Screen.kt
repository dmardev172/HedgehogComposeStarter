package pl.dmardev172.hedgefirstapp.screen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details")
}