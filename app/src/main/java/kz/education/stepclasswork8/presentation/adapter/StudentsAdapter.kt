package kz.education.stepclasswork8.presentation.adapter

import android.R.attr.fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.data.Student
import kz.education.stepclasswork8.presentation.activity.MainActivity
import kz.education.stepclasswork8.presentation.fragment.StudentDetailFragment
import kz.education.stepclasswork8.presentation.viewholder.StudentsHolder


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

        (holder as StudentsHolder).itemView.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            val fragment = StudentDetailFragment();
            bundle.putParcelable("STUDENT", students.get(position))
            fragment.setArguments(bundle)
            val fragmentManager: FragmentManager = (context as MainActivity).fragmentMenager
            fragmentManager?.beginTransaction()?.add(R.id.activity_main_relative_layout_fragment_container_students,
                fragment,"StudentDetailFragment")
                ?.addToBackStack(null)
                ?.commit()
        })
    }

}