package kz.education.stepclasswork8.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class StudentEntity(
    @PrimaryKey
    var id:Int,
    var name:String,
    var description: String,
    var group : String,
    var mark : Float,
    var avatar:String,
    var show :Boolean
)