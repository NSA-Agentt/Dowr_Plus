package xyz.sina.dowr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Text("Should be start btn and other stuff")

}
