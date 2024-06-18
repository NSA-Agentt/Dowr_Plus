package xyz.sina.dowr.alertDialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import xyz.sina.dowr.navigation.Screens

@Composable
fun Dialog(onDismiss:() -> Unit,navController: NavHostController){
    AlertDialog(onDismissRequest = onDismiss, confirmButton = {  },
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Button(onClick = {
                    navController.navigate(Screens.ScreenInGame.route)
                }){
                    Text(text = "Going to the InGame Screen")
                }
            }
        }
        )
}