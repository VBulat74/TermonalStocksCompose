package ru.com.bulat.termonalstockscompose.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun Test(){

    var number by remember {
        mutableStateOf(0)
    }

    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "")
    }
}