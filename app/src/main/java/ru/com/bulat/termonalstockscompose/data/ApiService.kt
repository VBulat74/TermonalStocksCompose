package ru.com.bulat.termonalstockscompose.data

import retrofit2.http.GET

interface ApiService {
    @GET("aggs/ticker/AAPL/range/1/hour/2023-01-01/2024-01-01?adjusted=true&sort=desc&limit=50000&apiKey=u7w09YQNTOriiGDH7ip6HggiT1X54bdG")
    suspend fun loadBars() : Result
}