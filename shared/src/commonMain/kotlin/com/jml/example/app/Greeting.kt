package com.jml.example.app

import com.jml.example.data.datasource.ApiServer
import com.jml.example.data.datasource.CountriesDataSource
import io.github.aakira.napier.Napier
import kotlinx.coroutines.runBlocking

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {

        runBlocking {

            try {
                CountriesDataSource(ApiServer())
                    .getCountries()
            }catch (e : Exception){
                Napier.e(e){
                    "Error "
                }
            }
        }

        return "Hello, ${platform.name}!"
    }
}