package kz.education.stepclasswork8.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class StudentEntity(
    @PrimaryKey
    var id:Int,
    var data:String
)