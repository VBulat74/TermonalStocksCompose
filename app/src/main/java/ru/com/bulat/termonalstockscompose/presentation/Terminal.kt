package ru.com.bulat.termonalstockscompose.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.TransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import ru.com.bulat.termonalstockscompose.data.Bar
import kotlin.math.roundToInt


private const val MIN_VISIBLE_BARS_COUNT = 20

@Composable
fun Terminal(
    bars : List<Bar>,
) {

    var terminalWith by remember {
        mutableStateOf(1f)
    }

    var visibleBarsCount by remember {
        mutableStateOf(100)
    }

    val barWidth by remember {
        derivedStateOf {
            terminalWith / visibleBarsCount
        }
    }

    var scrolledBy by remember {
        mutableStateOf(1f)
    }

    val visibleBars by remember {
        derivedStateOf {
            val indexStart = (scrolledBy / barWidth).roundToInt().coerceAtLeast(0)
            val endIndex = (indexStart + visibleBarsCount).coerceAtMost(bars.size)
            bars.subList(indexStart, endIndex)
        }
    }

    val transformableState = TransformableState { zoomChange, panChange, _ ->
        visibleBarsCount = (visibleBarsCount / zoomChange).roundToInt()
            .coerceIn(MIN_VISIBLE_BARS_COUNT, bars.size)
//            .coerceAtLeast(MIN_VISIBLE_BARS_COUNT)
//            .coerceAtMost(bars.size)

        scrolledBy = (scrolledBy + panChange.x)
            .coerceAtLeast(0f)
            .coerceAtMost(barWidth * bars.size - terminalWith)
    }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .transformable(transformableState),

        ) {

        val max = visibleBars.maxOf { it.high }
        val min = visibleBars.minOf { it.low }

        terminalWith = size.width

        val pxPerPoint = size.height / (max - min)

        translate(left = scrolledBy) {
            bars
                .forEachIndexed { index, bar ->

                    val offsetX = size.width - (barWidth * index)

                    drawLine(
                        color = Color.White,
                        start = Offset(offsetX, size.height - ((bar.low - min) * pxPerPoint)),
                        end = Offset(offsetX, size.height - ((bar.high - min) * pxPerPoint)),
                        strokeWidth = 1f
                    )

                    drawLine(
                        color = if (bar.open < bar.close) {
                            Color.Green
                        } else {
                            Color.Red
                        },
                        start = Offset(offsetX, size.height - ((bar.open - min) * pxPerPoint)),
                        end = Offset(offsetX, size.height - ((bar.close - min) * pxPerPoint)),
                        strokeWidth = barWidth / 2
                    )

                }
        }
    }
}