package com.epiafric.epiarfic_mobile_app.repository

import androidx.lifecycle.LiveData
import com.epiafric.epiarfic_mobile_app.database.DatabaseRepo
import com.epiafric.epiarfic_mobile_app.database.EntriesDao
import com.epiafric.epiarfic_mobile_app.model.Data
import com.epiafric.epiarfic_mobile_app.network.EntriesApiService
import com.epiafric.epiarfic_mobile_app.network.NetworkRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EpiAfricRepository (private val api:EntriesApiService, private val dao: EntriesDao):NetworkRepo,DatabaseRepo{
    override suspend fun setRecentEntries(recentResponseList: List<Data>) {
        dao.setRecentEntries(recentResponseList)
    }


     suspend fun getRecentFromApi() {
       withContext(Dispatchers.IO){
           val entries = api.getRecentFromApi(300).await()
          dao.setRecentEntries(entries.data)
       }


    }

    override fun getRecentFromDatabase(): LiveData<List<Data>> {
        return dao.getRecentFromDatabase()
    }


    fun getCategory(category: String): LiveData<List<Data>> {
        return dao.getCategoryFromDatabase(category)
    }

}