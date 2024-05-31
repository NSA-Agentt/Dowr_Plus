package xyz.sina.dowr.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import xyz.sina.dowr.Main
import xyz.sina.dowr.tutorial.Tutorial


@Composable
fun Navigation(navController : NavHostController = rememberNavController()){

    NavHost(navController = navController, startDestination = Screens.ScreenMain.route){
        composable(Screens.ScreenMain.route){

            Main(onNavigateToTutorial = {navController.navigate(route = Screens.ScreenTutorial.route)})

        }
        composable(Screens.ScreenTutorial.route){
            Tutorial(
                //onNavigateToMain = {navController.navigate(route = Screens.ScreenMain.route )}
            )
        }
    }
}

class NavigationTaskActions(private val navController: NavHostController){
    fun navigateToMain(){


    }
}