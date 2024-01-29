package ru.com.bulat.termonalstockscompose.presentation

import ru.com.bulat.termonalstockscompose.data.Bar

sealed class TerminalScreenState {

    object Initial : TerminalScreenState()

    object Loading : TerminalScreenState()

    data class Content (val barList : List<Bar>, val timeFrame : TimeFrame)  :TerminalScreenState()
}