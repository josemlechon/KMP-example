package com.jml.example.data.datasource

import com.jml.example.data.datasource.models.CountryResponse
import io.github.aakira.napier.Napier
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.utils.io.core.use

interface CountriesDataSource{

    suspend fun getCountries(): List<CountryResponse>
}