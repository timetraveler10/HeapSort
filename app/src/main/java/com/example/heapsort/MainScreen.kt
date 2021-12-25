package com.example.heapsort

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heapsort.ui.MyTextField
import com.example.heapsort.ui.theme.VM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(vm: VM ,           navigateToSourceCode:()->Unit
) {

    var value by remember { mutableStateOf("") }
    val unsortedList = vm.unsortedList.collectAsState()
    val sortedList = vm.sortedList.collectAsState()

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {


        MyTextField(
            value = value,
            onTextChange = { value = it },
            modifier = Modifier.fillMaxWidth(),
            onDoneClick = {
                vm.unsortedList.value.clear()
            }, {
                IconButton(onClick = { vm.unsortedList.value.clear() }) {
                    Icon(
                        imageVector = Icons.Default.Clear, contentDescription = null
                    )

                }
            }
        )

        Button(onClick = {
            if (value.isEmpty()) {
                Toast.makeText(context, "Please Enter An Item", Toast.LENGTH_SHORT).show()
            } else {

                try {

                    vm.unsortedList.value.add(value.toInt())
                    value = ""

                } catch (e: Exception) {
                    Toast.makeText(context, "Enter An Integer", Toast.LENGTH_SHORT).show()

                }
            }

        },
            modifier = Modifier.fillMaxWidth(), content = { Text(text = "Add") })

        Spacer(modifier = Modifier.padding(vertical = 6.dp))

        Text(
            text = "Unsorted Array \n ${unsortedList.value}",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )

        Button(onClick = {
            try {

                scope.launch(Dispatchers.Main) {
                    vm.sortList()

                }
            } catch (e: Exception) {

            }
        }, modifier = Modifier.fillMaxWidth(), content = { Text(text = "Sort") })

        Spacer(modifier = Modifier.padding(vertical = 6.dp))

        Text(
            text = "Sorted Array \n ${sortedList.value}",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(20.dp))

        Button(onClick = {
          navigateToSourceCode()
        }, modifier = Modifier.fillMaxWidth(), content = { Text(text = "Source Code") })

    }


}

