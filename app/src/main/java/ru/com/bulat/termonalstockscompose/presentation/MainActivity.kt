package ru.com.bulat.termonalstockscompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test()
//            TermonalStocksComposeTheme {
//                val viewModel: TerminalViewModel = viewModel()
//                val screenState = viewModel.state.collectAsState()
//                when (val currentState = screenState.value) {
//                    is TerminalScreenState.Content -> {
//                        Terminal(bars = currentState.barList)
//                    }
//
//                    is TerminalScreenState.Initial -> {}
//                }
//            }
        }
    }
}
