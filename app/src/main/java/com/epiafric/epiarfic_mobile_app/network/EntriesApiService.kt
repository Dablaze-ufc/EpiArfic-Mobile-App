package com.epiafric.epiarfic_mobile_app.network

import com.epiafric.epiarfic_mobile_app.model.EntriesData
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface EntriesApiService {
    @GET("reports")
     fun getRecentFromApi(): Deferred<EntriesData>
}