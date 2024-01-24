package com.jml.example.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging

class ApiServerConfiguration {

    private val httpClient  = httpClient {

        it.install(Logging){

            level = LogLevel.HEADERS
            logger =  object : Logger { // Logger.DEFAULT
                override fun log(message: String) {
                  // todo implement  Napier
                }

            }
        }
    }


}

expect fun httpClient(config: (HttpClientConfig<*>) -> Unit = {} ) : HttpClient