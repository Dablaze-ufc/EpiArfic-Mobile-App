package com.epiafric.epiarfic_mobile_app.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://epiafric.herokuapp.com/api/v1/reports"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

object EntriesApi{
    private val retrofit =
        Retrofit.Builder().addCallAdapterFactory(CoroutineCallAdapterFactory()).addConverterFactory(MoshiConverterFactory.create(
            moshi)).baseUrl(BASE_URL).build()

    val retrofitService  : EntriesApiService by lazy {
        retrofit.create(EntriesApiService::class.java)
    }
}