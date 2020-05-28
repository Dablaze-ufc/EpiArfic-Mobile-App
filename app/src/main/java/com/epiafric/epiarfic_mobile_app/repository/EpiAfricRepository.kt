package com.epiafric.epiarfic_mobile_app.repository

import com.epiafric.epiarfic_mobile_app.database.DatabaseRepo
import com.epiafric.epiarfic_mobile_app.database.EntriesDao
import com.epiafric.epiarfic_mobile_app.network.EntriesApiService
import com.epiafric.epiarfic_mobile_app.network.NetworkRepo

class EpiAfricRepository (private val api:EntriesApiService, private val dao: EntriesDao):NetworkRepo,DatabaseRepo{

}