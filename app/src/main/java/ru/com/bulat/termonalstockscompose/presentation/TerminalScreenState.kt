package ru.com.bulat.termonalstockscompose.presentation

import ru.com.bulat.termonalstockscompose.data.Bar

sealed class TerminalScreenState {

    object Initial : TerminalScreenState()

    data class Content (val barList : List<Bar>)  :TerminalScreenState()
}