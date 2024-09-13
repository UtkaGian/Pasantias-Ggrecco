package com.example.digitalgateopen.DigitalGate

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("search.php?n={name}&desc=Digimon%20Card%20Game&sortdirection=ascinclude%20a%20Digimon%20card")
    suspend fun getDigimon(
        @Path("name") DigimonName:String
    ):Response<DigimonItemResponse>
}