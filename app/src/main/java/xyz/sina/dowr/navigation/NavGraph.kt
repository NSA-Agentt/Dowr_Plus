package xyz.sina.dowr.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import xyz.sina.dowr.Main
import xyz.sina.dowr.inGame.InGameScreen
import xyz.sina.dowr.tutorial.Tutorial


// TODO : use sharedPreference for saving next startUp screen
@Composable
fun Navigation(){
    val navController : NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.ScreenTutorial.route){
        composable(Screens.ScreenMain.route){
            Main(navController)
        }
        composable(Screens.ScreenTutorial.route){
            Tutorial(navController)
        }
        composable(Screens.ScreenInGame.route){
            InGameScreen()
        }
    }
}

