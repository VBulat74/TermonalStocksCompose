package ru.com.bulat.termonalstockscompose.presentation

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.parcelize.Parcelize
import ru.com.bulat.termonalstockscompose.data.Bar
import kotlin.math.roundToInt

@Parcelize
data class TerminalState(
    val barList : List<Bar>,
    val visibleBarsCount : Int = 100,
    val terminalWith : Float = 1f,
    val scrolledBy : Float = 1f,
) : Parcelable {
    val barWidth : Float
        get() = terminalWith / visibleBarsCount

    val visibleBars : List<Bar>
        get() {
            val indexStart = (scrolledBy / barWidth).roundToInt().coerceAtLeast(0)
            val endIndex = (indexStart + visibleBarsCount).coerceAtMost(barList.size)
            return barList.subList(indexStart, endIndex)
        }
}

@Composable
fun rememberTerminalState(bars : List<Bar>) : MutableState<TerminalState> {
    return rememberSaveable {
        mutableStateOf(TerminalState(barList = bars))
    }
}


