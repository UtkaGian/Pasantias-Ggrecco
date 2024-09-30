package com.example.digitalgateopen.DigitalGate

import com.google.gson.annotations.SerializedName

data class DigimonItemResponse(
    @SerializedName("name") var Name:String?=null,
    @SerializedName("id") var Id:String?=null,
    @SerializedName("color") var Color:String?=null,
    @SerializedName("color2") var Color2:String?=null,
    @SerializedName("dp") var Dp:Int?=0
)