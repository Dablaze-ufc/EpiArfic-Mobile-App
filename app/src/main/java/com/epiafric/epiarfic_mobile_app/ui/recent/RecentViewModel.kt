package com.epiafric.epiarfic_mobile_app.ui.recent

import android.app.Application
import androidx.lifecycle.*
import com.epiafric.epiarfic_mobile_app.database.EntriesDatabase
import com.epiafric.epiarfic_mobile_app.model.Data
import com.epiafric.epiarfic_mobile_app.model.EntriesData
import com.epiafric.epiarfic_mobile_app.network.EntriesApi.retrofitService
import com.epiafric.epiarfic_mobile_app.repository.EpiAfricRepository
import com.epiafric.epiarfic_mobile_app.util.Event
import com.epiafric.epiarfic_mobile_app.util.Result
import com.epiafric.epiarfic_mobile_app.util.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecentViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : EpiAfricRepository

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val dao = EntriesDatabase.getInstance(application).entriesDao

     val  recentResponse = MutableLiveData<Event<Result<EntriesData>>> ()

    private val _recent : LiveData<List<Data>>

    init {
        repository = EpiAfricRepository(retrofitService,dao)

        getRecentFromDatabase()

        _recent = repository.getRecentFromDatabase()
    }

    private fun getRecentFromDatabase() {
        recentResponse.postValue(
            Event(
                Result(
                    State.LOADING,
                    message = "Loading......",
                    isRefreshing = true
                )
            )
        )


                retrofitService.getRecentFromApi().enqueue(object : Callback<EntriesData>{
                    override fun onFailure(call: Call<EntriesData>, t: Throwable) {
                        recentResponse.postValue(
                            Event(
                                Result(
                                    State.ERROR,
                                    message = t.localizedMessage,
                                    error = t,
                                    isRefreshing = false
                                )
                            )
                        )
                    }

                    override fun onResponse(
                        call: Call<EntriesData>,
                        response: Response<EntriesData>
                    ) {
                        if (response.isSuccessful){
                            uiScope.launch {
                                response.body()?.data?.let {
                                    repository.setRecentEntries(it)
                                    recentResponse.postValue(
                                        Event(
                                            Result(
                                                State.SUCCESS,
                                                message = "Success",
                                                isRefreshing = false
                                            )
                                        )
                                    )
                                }
                                }
                            }
                        }

                })






        }


   fun getRecent() = _recent


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}

@Suppress("UNCHECKED_CAST")
class RecentViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecentViewModel::class.java)){

            return RecentViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}