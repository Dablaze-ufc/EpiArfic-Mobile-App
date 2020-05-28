package com.epiafric.epiarfic_mobile_app.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.epiafric.epiarfic_mobile_app.model.Data

@Dao
interface EntriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setRecentEntries(recentResponseList: List<Data>)

    @Query("SELECT * FROM recent_entries")
    fun getRecentFromDatabase(): LiveData<List<Data>>

}