package com.jml.example.data.datasource

import io.mockative.Mock
import io.mockative.classOf
import io.mockative.mock
import kotlin.test.Test
import kotlin.test.assertEquals

class CountriesDataSourceTest {


    @Test
    fun testFails(){

        assertEquals(1 , 0+1, "")
    }

    private class TestScope{


        @Mock
        val api = mock(classOf<ApiServer>())


        val sut : CountriesDataSource by lazy { CountriesDataSourceImpl(api)}
    }
}