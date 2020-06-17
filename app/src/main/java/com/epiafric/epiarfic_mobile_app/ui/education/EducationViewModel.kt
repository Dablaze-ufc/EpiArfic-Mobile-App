package com.epiafric.epiarfic_mobile_app.ui.education

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.epiafric.epiarfic_mobile_app.database.EntriesDatabase
import com.epiafric.epiarfic_mobile_app.model.Data
import com.epiafric.epiarfic_mobile_app.network.EntriesApi.retrofitService
import com.epiafric.epiarfic_mobile_app.repository.EpiAfricRepository

class EducationViewModel(application: Application):
    AndroidViewModel(application) {

 val epiafric: EpiAfricRepository

    private val dao = EntriesDatabase.getInstance(application).entriesDao
    init {
        epiafric = EpiAfricRepository(retrofitService, dao)
    }
    val education = epiafric.getCategory("Education")


    private val _navigateToDataDetail = MutableLiveData<Data>()

    val navigateToDataDetail: LiveData<Data>
        get() = _navigateToDataDetail

    fun onDataClicked(data: Data){
        _navigateToDataDetail.value = data
    }

    fun onDetailsNavigatedDone(){
        _navigateToDataDetail.value = null
    }


}
