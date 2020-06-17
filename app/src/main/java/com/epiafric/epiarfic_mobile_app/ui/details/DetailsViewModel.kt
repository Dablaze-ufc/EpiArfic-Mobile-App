package com.epiafric.epiarfic_mobile_app.ui.details


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.epiafric.epiarfic_mobile_app.model.Data

class DetailsViewModel(val data: Data) : ViewModel() {

}
@Suppress("UNCHECKED_CAST")
class  DetailsViewModelFactory(private val data: Data): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom( DetailsViewModel::class.java)){

            return  DetailsViewModel(data) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}