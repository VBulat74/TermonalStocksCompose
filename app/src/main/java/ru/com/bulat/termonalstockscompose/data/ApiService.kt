package ru.com.bulat.termonalstockscompose.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("aggs/ticker/AAPL/range/{timeFrame}/2023-01-01/2024-01-01?adjusted=true&sort=desc&limit=50000&apiKey=u7w09YQNTOriiGDH7ip6HggiT1X54bdG")
    suspend fun loadBars(
        @Path("timeFrame") timeFrame : String
    ) : Result
}