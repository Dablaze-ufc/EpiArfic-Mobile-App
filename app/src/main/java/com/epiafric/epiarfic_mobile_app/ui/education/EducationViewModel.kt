package com.epiafric.epiarfic_mobile_app.ui.education

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.epiafric.epiarfic_mobile_app.database.EntriesDao
import com.epiafric.epiarfic_mobile_app.database.EntriesDatabase

class EducationViewModel(val dataSource: EntriesDao, application: Application):
    AndroidViewModel(application) {


    val education = EntriesDatabase.getInstance(application).
                    entriesDao.getCategoryFromDatabase("education")


}
