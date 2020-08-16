package com.example.android.navigation.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NameList::class], version = 1, exportSchema = false)
abstract class NameListDatabase : RoomDatabase() {

    abstract val DatabaseDao: DatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: NameListDatabase? = null

        fun getInstance(context: Context): NameListDatabase{
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            NameListDatabase::class.java,
                            "name_history_database"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}