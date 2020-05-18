package com.epiafric.epiarfic_mobile_app.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class EntriesDatabase : RoomDatabase() {
    abstract val entriesDao: EntriesDao

    companion object {
        @Volatile
        private var INSTANCE: EntriesDatabase? = null
        fun getInstance(context: Context): EntriesDatabase? {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        EntriesDatabase::class.java,
                        "entries_database"
                    ).fallbackToDestructiveMigration().build()
                }
                return instance
            }
        }
    }
}