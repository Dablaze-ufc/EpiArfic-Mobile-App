package com.epiafric.epiarfic_mobile_app.ui.vunerable_population

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.epiafric.epiarfic_mobile_app.database.EntriesDatabase
import com.epiafric.epiarfic_mobile_app.network.EntriesApi.retrofitService
import com.epiafric.epiarfic_mobile_app.repository.EpiAfricRepository

class VunerablePopulationViewModel(application: Application) : AndroidViewModel(application) {

    val epicAfric: EpiAfricRepository
    
    val dao = EntriesDatabase.getInstance(application).entriesDao

    init {
        epicAfric = EpiAfricRepository(retrofitService, dao)
    }

    val vulnerable = epicAfric.getCategory("Vulnerable Population")
}
