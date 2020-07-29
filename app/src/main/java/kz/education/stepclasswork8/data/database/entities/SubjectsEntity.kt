package kz.education.stepclasswork8.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SubjectsEntity (
    @PrimaryKey
    var id:Int,
    var name:String
)