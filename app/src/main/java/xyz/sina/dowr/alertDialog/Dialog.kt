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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDirection
import androidx.navigation.NavHostController
import xyz.sina.dowr.navigation.Screens
import xyz.sina.dowr.utils.DialogTexts
import xyz.sina.dowr.utils.General
import xyz.sina.dowr.utils.Txts


@Composable
fun FirstDialog(onDismiss:() -> Unit,navController: NavHostController){

    var showDialogSecond by remember{ mutableStateOf(false) }
    var numberOfPersons by  remember {mutableStateOf("")}
    if (showDialogSecond) SecondDialog(onDismiss = {showDialogSecond = false} ,navController,numberOfPersons)

    AlertDialog(onDismissRequest = onDismiss, confirmButton = {  },
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text(text = DialogTexts.numberOfPlayers)
                OutlinedTextField(value = numberOfPersons, onValueChange = { numberOfPersons  = it }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
                Button(onClick = {
                    showDialogSecond = true
                }){
                    Text(text = General.next )
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
                Text(text = DialogTexts.nameOfPlayers)
                playerNames.forEachIndexed { index, name ->
                    OutlinedTextField(value = name ,
                        onValueChange = { newName ->
                        playerNames = playerNames.toMutableList().also { it[index] = newName }
                    }, label = {Text("بازیکن ${index+1}")},
                        textStyle = TextStyle(textDirection = TextDirection.Content))
                }
                Button(onClick = {
                    navController.navigate(Screens.ScreenInGame.route)
                }){
                    Text(text = General.start)
                }

            }

        })
}


// TODO Please add third dialog for inGame setting.