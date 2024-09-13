package com.example.digitalgateopen.DigitalGate

import com.google.gson.annotations.SerializedName

data class DigimonItemResponse(
    @SerializedName("name") var Name:String?=null,
    @SerializedName("id") var Id:String?=null
)