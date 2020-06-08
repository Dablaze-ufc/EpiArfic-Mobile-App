package com.epiafric.epiarfic_mobile_app.ui.community

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.epiafric.epiarfic_mobile_app.database.EntriesDao
import com.epiafric.epiarfic_mobile_app.database.EntriesDatabase
import com.epiafric.epiarfic_mobile_app.network.EntriesApi.retrofitService
import com.epiafric.epiarfic_mobile_app.repository.EpiAfricRepository

class CommunityViewModel(val dataSource: EntriesDao, application: Application)
    : AndroidViewModel(application) {

    val epicAfric: EpiAfricRepository

    private val dao = EntriesDatabase.getInstance(application).entriesDao

    init {
        epicAfric = EpiAfricRepository(retrofitService, dao)
    }

    val community = epicAfric.getCategory("community")
}
