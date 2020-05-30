package com.epiafric.epiarfic_mobile_app.network

import com.epiafric.epiarfic_mobile_app.model.EntriesData
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface EntriesApiService {
    @GET("reports")
     fun getRecentFromApi(@Query("size") size: Int): Deferred<EntriesData>
}