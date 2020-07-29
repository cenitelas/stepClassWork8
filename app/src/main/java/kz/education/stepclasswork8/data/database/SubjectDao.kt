package kz.education.stepclasswork8.data.database

import androidx.room.*
import kz.education.stepclasswork8.data.database.entities.SubjectsEntity

@Dao
interface SubjectDao {
    @Query("SELECT * FROM SubjectsEntity WHERE id == :id")
    fun getById(id: Int): SubjectsEntity

    @Query("SELECT * FROM SubjectsEntity")
    fun getList(): List<SubjectsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: SubjectsEntity)

    @Update
    fun update(entity: SubjectsEntity)

    @Delete
    fun delete(entity: SubjectsEntity)
}