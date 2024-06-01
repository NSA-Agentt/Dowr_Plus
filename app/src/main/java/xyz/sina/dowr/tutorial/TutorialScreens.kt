package xyz.sina.dowr.tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import xyz.sina.dowr.tutorial.ui.theme.DowrTheme

class TutorialScreens : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DowrTheme {
                //Tutorial(navController = rememberNavController())
            }
        }
    }
}

