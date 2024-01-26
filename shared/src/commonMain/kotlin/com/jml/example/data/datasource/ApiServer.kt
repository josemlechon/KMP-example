package com.jml.example.data.datasource

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiServer {
    companion object {

        const val HOST = "restcountries.com/v3.1/"
    }

    val httpClient = httpClient { config->

        config.install(Logging) {

            level = LogLevel.HEADERS
            logger = object : Logger { // Logger.DEFAULT
                override fun log(message: String) {
                    Napier.v { "Http Client $message" }
                }
            }
        }

        config.install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }.also { Napier.base(DebugAntilog()) }

}

suspend fun HttpClient.getHttps(block: (URLBuilder) -> Unit ): HttpResponse {
    return this.get {
        url {
            protocol = URLProtocol.HTTPS
            host = ApiServer.HOST
            block(this)
        }
    }
}

expect fun httpClient(config: (HttpClientConfig<*>) -> Unit = {}): HttpClient