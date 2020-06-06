package com.epiafric.epiarfic_mobile_app.ui.education

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.epiafric.epiarfic_mobile_app.database.EntriesDao
import com.epiafric.epiarfic_mobile_app.database.EntriesDatabase
import com.epiafric.epiarfic_mobile_app.network.EntriesApi.retrofitService
import com.epiafric.epiarfic_mobile_app.repository.EpiAfricRepository

class EducationViewModel(val dataSource: EntriesDao, application: Application):
    AndroidViewModel(application) {

 val epiafric: EpiAfricRepository

    private val dao = EntriesDatabase.getInstance(application).entriesDao
    init {
        epiafric = EpiAfricRepository(retrofitService, dao)
    }
    val education = epiafric.getCategory("Education")


}
