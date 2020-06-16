package com.epiafric.epiarfic_mobile_app.ui.others

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import com.epiafric.epiarfic_mobile_app.database.EntriesDatabase
import com.epiafric.epiarfic_mobile_app.network.EntriesApi
import com.epiafric.epiarfic_mobile_app.repository.EpiAfricRepository

class OthersViewModel ( application: Application)
    : AndroidViewModel(application) {

    val epicAfric: EpiAfricRepository

    private val dao = EntriesDatabase.getInstance(application).entriesDao

    init {
        epicAfric = EpiAfricRepository(EntriesApi.retrofitService, dao)
    }

    val others = epicAfric.getCategory("others")


}
