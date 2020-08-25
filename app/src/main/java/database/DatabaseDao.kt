package database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addname(name: NameList)

    @Query("SELECT * FROM contact_table ORDER BY listId ASC")
    fun getAllData(): LiveData<List<NameList>>
}