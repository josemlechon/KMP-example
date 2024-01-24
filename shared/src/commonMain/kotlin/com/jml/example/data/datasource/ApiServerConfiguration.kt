package com.jml.example.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

class ApiServerConfiguration {


}

expect fun httpClient(config: (HttpClientConfig<*>) -> Unit = {} ) : HttpClient