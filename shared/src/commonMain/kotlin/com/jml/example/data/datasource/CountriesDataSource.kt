package com.jml.example.data.datasource

import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.utils.io.core.use

class CountriesDataSource {



    private val client = httpClient()

    suspend fun getCountries() {

        ApiServer().httpClient.getHttps { urlBuilder ->
            urlBuilder.path("all")
        }

    }
}