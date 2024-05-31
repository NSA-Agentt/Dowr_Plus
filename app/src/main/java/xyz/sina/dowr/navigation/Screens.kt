package xyz.sina.dowr.navigation

sealed class Screens(val route : String ) {
    data object ScreenTutorial: Screens("ScreenTutorial")
    data object ScreenMain : Screens("ScreenMain")
    data object ScreenInGame : Screens("ScreenInGame")
}