package com.jml.example.data.datasource.models

import kotlinx.serialization.Serializable

@Serializable
data class CountryResponse (
    val name : CountryNameResponse,
    val region : String = "",
    val subregion : String = "",
    val languages : Map<String, String> = hashMapOf(),
    val flags : FlagResponse
)

@Serializable data class CountryNameResponse (
    val common : String = "",
    val official : String = ""
)

@Serializable data class FlagResponse(
    val png : String = "",
    val svg : String = "",
    val alt: String= ""
)