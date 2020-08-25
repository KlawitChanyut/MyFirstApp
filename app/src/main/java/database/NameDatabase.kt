package database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NameList::class], version = 1, exportSchema = false)
abstract class NameDatabase : RoomDatabase() {

    abstract val databaseDao: DatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: NameDatabase? = null

        fun getInstance(context: Context): NameDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        NameDatabase::class.java,
                        "name_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}