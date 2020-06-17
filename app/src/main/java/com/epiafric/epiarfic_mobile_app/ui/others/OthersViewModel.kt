package com.epiafric.epiarfic_mobile_app.ui.others

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.epiafric.epiarfic_mobile_app.database.EntriesDatabase
import com.epiafric.epiarfic_mobile_app.model.Data
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
