package kz.education.stepclasswork8.Utils

import kz.education.stepclasswork8.data.Student

class StudentsUtilsUseCase {

    fun sortByName(students:ArrayList<Student>) {
        return students.sortBy{student->student.name}
    }

    fun sortByMark(students: ArrayList<Student>){
        return students.sortBy { student -> student.mark  }
    }

    fun sortByRandom(students: ArrayList<Student>){
        return students.shuffle()
    }

    fun sortByGroup(students: ArrayList<Student>){
        return students.sortBy { student -> student.group  }
    }


    fun searchByName(students: ArrayList<Student>, query : String):ArrayList<Student>{
        if(query.isNotEmpty()){
            students.forEach { student->
                student.show = student.name.toUpperCase().indexOf(query.toUpperCase())>-1
             }
        }else{
            students.forEach { student->student.show=true }
        }
        return students
    }
}