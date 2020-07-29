package kz.education.stepclasswork8.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import kz.education.stepclasswork8.data.database.entities.StudentEntity
import kz.education.stepclasswork8.data.database.entities.SubjectsEntity

@Database(entities = [StudentEntity::class,SubjectsEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao():StudentDao
    abstract fun subjectDao():SubjectsEntity
}