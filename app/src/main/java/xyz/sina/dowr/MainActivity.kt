package xyz.sina.dowr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import xyz.sina.dowr.alertDialog.FirstDialog
import xyz.sina.dowr.navigation.Navigation
import xyz.sina.dowr.navigation.Screens
import xyz.sina.dowr.ui.theme.DowrTheme
import xyz.sina.dowr.ui.theme.Orange
import xyz.sina.dowr.ui.theme.Vanilla

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
data class  BottomNavigationItems (
    val title :String ,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
)

@Composable
fun Main(navController: NavHostController) {
    // TODO PLEASE ADD ICONS FOR GAME AND HELP

    var showDialog by remember{ mutableStateOf(false) }


    if(showDialog) FirstDialog(onDismiss = {showDialog = false},navController = navController)


    val items = listOf(
        BottomNavigationItems(
            title = "تنظیمات",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings
        ),

        BottomNavigationItems(
            title = "بازی",
            selectedIcon = Icons.Filled.PlayArrow,
            unselectedIcon = Icons.Outlined.PlayArrow
        ),

        BottomNavigationItems(
            title = "راهنما",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings
        )

    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(1)
    }

    Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Orange, bottomBar = {
        // please change round corner values
        NavigationBar(containerColor = Vanilla ,modifier = Modifier.padding(4.dp).clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp ,0.dp))) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = { selectedItemIndex = index },
                    label = { Text(text = item.title)},
                    icon = {
                        Icon(if (index == selectedItemIndex){
                            item.selectedIcon
                        }else{
                            item.unselectedIcon
                        }, contentDescription = null )
                    }
                )
            }
        }
    }) { innerPadding ->

        Column(Modifier.padding(innerPadding).fillMaxHeight(), verticalArrangement = Arrangement.Center) {
            // gif or image of app
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                IconButton(onClick = {
                    showDialog = true
                }) {
                    Icon(painter = painterResource(id = R.drawable.play_circle_24), contentDescription = null)
                }
            }
        }

    }

}
