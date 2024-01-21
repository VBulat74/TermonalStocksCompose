package ru.com.bulat.termonalstockscompose.data

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("results") val barLists : List<Bar>
)
