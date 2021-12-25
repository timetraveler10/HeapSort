package com.example.heapsort.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heapsort.MainScreen

sealed class NavigationRoutes(val route:String) {
    object MainScreen:NavigationRoutes("MainScreen")
    object DetailScreen:NavigationRoutes("DetailScreen")
}

@Composable
fun Navigation(vm: VM) {
    
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = NavigationRoutes.MainScreen.route ){
        
        
        composable(route = NavigationRoutes.MainScreen.route){
            
            MainScreen(vm = vm , navigateToSourceCode = {navController.navigate(NavigationRoutes.DetailScreen.route)})
            
        }

        composable(route = NavigationRoutes.DetailScreen.route){

            LazyColumn(modifier = Modifier.fillMaxSize().padding(10.dp)){
                item { 
                    Text(text = "private fun buildMaxHeap(array: IntArray) {\n" +
                            "\n" +
                            "    for (i in ((array.size/2) - 1) downTo 0) {\n" +
                            "        maxHeapify(array, i)\n" +
                            "    }\n" +
                            "\n" +
                            "}\n" +
                            "\n" +"\n"+
                            "private fun maxHeapify(array: IntArray, rootIndex: Int, heapSize: Int = array.size - 1) {\n" +
                            "\n" +
                            "    val leftChildIndex = (2 * rootIndex) + 1\n" +
                            "    val rightChildIndex = (2 * rootIndex) + 2\n" +
                            "    var largestElementIndex = rootIndex\n" +
                            "\n" +
                            "    if (leftChildIndex <= heapSize && array[leftChildIndex] > array[rootIndex]) {\n" +
                            "        largestElementIndex = leftChildIndex\n" +
                            "    }\n" +
                            "\n" +
                            "    if (rightChildIndex <= heapSize && array[rightChildIndex] > array[largestElementIndex]) {\n" +
                            "        largestElementIndex = rightChildIndex\n" +
                            "    }\n" +
                            "\n" +
                            "    if (largestElementIndex != rootIndex) {\n" +
                            "        val temp = array[rootIndex]\n" +
                            "        array[rootIndex] = array[largestElementIndex]\n" +
                            "        array[largestElementIndex] = temp\n" +
                            "        maxHeapify(array, largestElementIndex, heapSize)\n" +
                            "    }\n" +
                            "\n" +
                            "}" , modifier = Modifier.fillMaxSize())
                }
            }

        }
        
    }
    
}