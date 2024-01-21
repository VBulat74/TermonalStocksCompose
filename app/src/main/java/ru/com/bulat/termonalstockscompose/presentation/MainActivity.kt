package ru.com.bulat.termonalstockscompose.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.com.bulat.termonalstockscompose.ui.theme.TermonalStocksComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TermonalStocksComposeTheme {
                val viewModel: TerminalViewModel = viewModel()
                val screenState = viewModel.state.collectAsState()
                when (val currentState = screenState.value) {
                    is TerminalScreenState.Content -> {
                        Log.d("MainActivity", currentState.barList.toString())
                    }

                    is TerminalScreenState.Initial -> {}
                }
            }
        }
    }
}
