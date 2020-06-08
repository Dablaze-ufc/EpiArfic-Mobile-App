package com.epiafric.epiarfic_mobile_app.ui.health

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epiafric.epiarfic_mobile_app.database.EntriesDatabase
import com.epiafric.epiarfic_mobile_app.network.EntriesApi.retrofitService
import com.epiafric.epiarfic_mobile_app.repository.EpiAfricRepository

class HealthViewModel(application: Application) : AndroidViewModel(application) {

    val epicAfric: EpiAfricRepository

    val dao = EntriesDatabase.getInstance(application).entriesDao

    init {
        epicAfric = EpiAfricRepository(retrofitService, dao)
    }

    val health = epicAfric.getCategory("Health")


}