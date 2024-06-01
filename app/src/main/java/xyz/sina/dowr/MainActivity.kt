package xyz.sina.dowr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import xyz.sina.dowr.navigation.Navigation
import xyz.sina.dowr.ui.theme.DowrTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DowrTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Main(navController: NavHostController) {
    Scaffold(Modifier.background(color = Color.Magenta)) { innerPadding ->
        Column(Modifier.padding(innerPadding), verticalArrangement = Arrangement.Center) {
            // gif or image of app
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.play_circle_24), contentDescription = null)
            }
        }

    }

}
