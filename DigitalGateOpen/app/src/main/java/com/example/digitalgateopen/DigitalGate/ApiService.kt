package com.example.digitalgateopen.DigitalGate

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search.php?")
    suspend fun getDigimon(
        @Query("n") name: String,
        @Query("desc") description: String = "Digimon Card Game",
        @Query("sortdirection") sortDirection: String = "asc"
    ):Response<List<DigimonItemResponse>>
}