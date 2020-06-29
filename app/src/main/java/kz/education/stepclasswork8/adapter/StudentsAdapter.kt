package kz.education.stepclasswork8.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.data.Student
import kz.education.stepclasswork8.viewholder.StudentsHolder

class StudentsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var context : Context? = null
    var students:ArrayList<Student>

    var currentGroup="";

    constructor(context: Context?,students:ArrayList<Student>){
        this.context=context;
        this.students= students.filter { student->student.show==true } as ArrayList<Student>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if(currentGroup!=students.get(viewType).group){
            currentGroup = students.get(viewType).group
            var view = LayoutInflater.from(context).inflate(R.layout.viewholder_student,parent,false)
            return StudentsHolder(view)
        }
        students.get(viewType).group = ""
        var view = LayoutInflater.from(context).inflate(R.layout.viewholder_student,parent,false)
        return StudentsHolder(view)
    }

    override fun getItemCount(): Int {
        return this.students.size ?:0
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as StudentsHolder).initiateBind(students.get(position))
    }

}