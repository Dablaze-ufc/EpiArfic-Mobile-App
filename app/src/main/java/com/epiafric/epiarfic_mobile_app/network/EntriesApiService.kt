package com.epiafric.epiarfic_mobile_app.network

import retrofit2.http.GET

interface EntriesApiService {
    @GET
    fun getRecent(){}
}