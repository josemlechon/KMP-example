package com.jml.example.data.datasource

import com.jml.example.data.datasource.models.CountryResponse
import io.github.aakira.napier.Napier
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.utils.io.core.use

class CountriesDataSource(private val apiServer: ApiServer) {

    suspend fun getCountries(): List<CountryResponse> {
        return try {
            val response = apiServer.httpClient.getHttps { urlBuilder ->
                urlBuilder.path("all")
            }

            if (response.status.value !in (200..299)) {

                throw Exception("Server call not working")
            }

            val countries = response.body<List<CountryResponse>>()

            countries
        } catch (e: Exception) {
            Napier.e(e) { "get Countries DS call has failed" }
            throw e
        }
    }
}