package com.epiafric.epiarfic_mobile_app.ui.research

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epiafric.epiarfic_mobile_app.database.EntriesDatabase
import com.epiafric.epiarfic_mobile_app.network.EntriesApi.retrofitService
import com.epiafric.epiarfic_mobile_app.repository.EpiAfricRepository

class ResearchViewModel(application: Application) : AndroidViewModel(application) {

    val epicAfric: EpiAfricRepository

    val dao = EntriesDatabase.getInstance(application).entriesDao

    init {
        epicAfric = EpiAfricRepository(retrofitService, dao)
    }

    val research = epicAfric.getCategory("Research")

}