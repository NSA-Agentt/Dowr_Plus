package xyz.sina.dowr.alertDialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavHostController
import xyz.sina.dowr.navigation.Screens



@Composable
fun FirstDialog(onDismiss:() -> Unit,navController: NavHostController){

    var showDialogSecond by remember{ mutableStateOf(false) }
    var numberOfPersons by  remember {mutableStateOf("")}
    if (showDialogSecond) SecondDialog(onDismiss = {showDialogSecond = false} ,navController,numberOfPersons)

    AlertDialog(onDismissRequest = onDismiss, confirmButton = {  },
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                OutlinedTextField(value = numberOfPersons, onValueChange = { numberOfPersons  = it }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),label = {Text("Number of Players")})
                Button(onClick = {
                    showDialogSecond = true
                    //navController.navigate(Screens.ScreenInGame.route)
                }){
                    Text(text = "Next")
                }
            }
        }
    )
}
@Composable
fun SecondDialog(onDismiss: () -> Unit,navController: NavHostController,numberOfPersons: String){
    var playerNames by remember { mutableStateOf(List(numberOfPersons.toInt()){""})}
    AlertDialog(onDismissRequest = onDismiss, confirmButton = {},
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text("Please enter your players name ")
                playerNames.forEachIndexed { index, name ->
                    OutlinedTextField(value = name , onValueChange = {newName ->
                        playerNames = playerNames.toMutableList().also { it[index] = newName }
                    }, label = {Text("Player ${index+1}")})
                }
                Button(onClick = {
                    navController.navigate(Screens.ScreenInGame.route)
                }){
                    Text(text = "Going to the InGame Screen")
                }

            }

        })
}