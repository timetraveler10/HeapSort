package com.example.heapsort.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect

class VM : ViewModel() {

    var unsortedList: MutableStateFlow<MutableList<Int>> = MutableStateFlow(mutableListOf())
    var sortedList: MutableStateFlow<MutableList<Int>> = MutableStateFlow(mutableListOf())

    suspend fun sortList(){

        this.unsortedList.collect {
            this.sortedList.value = it.sorted().toMutableList()
        }
    }


}