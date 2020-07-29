package kz.education.stepclasswork8.data.database

import androidx.room.*
import kz.education.stepclasswork8.data.database.entities.StudentEntity

@Dao
interface StudentDao {
    @Query("SELECT * FROM StudentEntity WHERE id == :id")
    fun getById(id: Int): StudentEntity

    @Query("SELECT * FROM StudentEntity")
    fun getList(): List<StudentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: StudentEntity)

    @Update
    fun update(entity: StudentEntity)

    @Delete
    fun delete(entity: StudentEntity)
}