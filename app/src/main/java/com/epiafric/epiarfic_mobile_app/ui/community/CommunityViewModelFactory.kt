package com.epiafric.epiarfic_mobile_app.ui.community

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.epiafric.epiarfic_mobile_app.database.EntriesDao


class CommunityViewModelFactory(private val dataSource: EntriesDao,
                                private val application: Application):
                                ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommunityViewModel::class.java)){
            return CommunityViewModel(dataSource, application) as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }

}