package com.opensource.composebasics.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {

    var count by mutableIntStateOf(0)

    fun incrementCount() {
        count++
    }
}