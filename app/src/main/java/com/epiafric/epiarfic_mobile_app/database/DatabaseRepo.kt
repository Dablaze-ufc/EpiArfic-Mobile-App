package com.epiafric.epiarfic_mobile_app.database

import androidx.lifecycle.LiveData
import com.epiafric.epiarfic_mobile_app.model.Data

interface DatabaseRepo {
    suspend fun setRecentEntries(recentResponseList: List<Data>)

    fun getRecentFromDatabase():LiveData<List<Data>>
}