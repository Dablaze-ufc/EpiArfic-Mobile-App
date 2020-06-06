package com.epiafric.epiarfic_mobile_app.ui.others

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class OthersViewModelFactory(private val application: Application):
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OthersViewModel::class.java)){
            return OthersViewModel(application) as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }

}