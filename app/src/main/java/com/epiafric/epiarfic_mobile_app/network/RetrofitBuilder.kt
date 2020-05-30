package com.epiafric.epiarfic_mobile_app.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://epiafric.herokuapp.com/api/v1/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()

object EntriesApi{
    private val retrofit =
        Retrofit.Builder().addCallAdapterFactory(CoroutineCallAdapterFactory()).addConverterFactory(MoshiConverterFactory.create(
            moshi)).client(okHttpClient).baseUrl(BASE_URL).build()

    val retrofitService  : EntriesApiService by lazy {
        retrofit.create(EntriesApiService::class.java)
    }
}