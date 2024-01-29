package ru.com.bulat.termonalstockscompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.com.bulat.termonalstockscompose.ui.theme.TermonalStocksComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TermonalStocksComposeTheme {
                Terminal()
            }
        }
    }
}
