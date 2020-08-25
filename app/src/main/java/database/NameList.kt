package database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class NameList(
        @PrimaryKey(autoGenerate = true)
        var listId: Long = 0L,

        @ColumnInfo(name = "names")
        val name: String
)