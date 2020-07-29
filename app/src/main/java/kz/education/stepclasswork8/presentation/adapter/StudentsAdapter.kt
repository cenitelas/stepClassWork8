package kz.education.stepclasswork8.presentation.adapter

import android.R.attr.fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.data.Student
import kz.education.stepclasswork8.presentation.activity.MainActivity
import kz.education.stepclasswork8.presentation.fragment.StudentDetailFragment
import kz.education.stepclasswork8.presentation.viewholder.StudentsHolder


class StudentsAdapter( private val students:ArrayList<Student>, private val listener : Listener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    interface Listener {

        fun onItemClick(students: Student)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_student,parent,false)
        return StudentsHolder(view)
    }

    override fun getItemCount(): Int {
        return this.students.size ?:0
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as StudentsHolder).initiateBind(students.get(position),listener, position)

//        (holder as StudentsHolder).itemView.setOnClickListener(View.OnClickListener {
//            val bundle = Bundle()
//            val fragment = StudentDetailFragment();
//            bundle.putParcelable("STUDENT", students.get(position))
//            fragment.setArguments(bundle)
//            val fragmentManager =
//            fragmentManager?.beginTransaction()?.add(R.id.activity_main_relative_layout_fragment_container_students,
//                fragment,"StudentDetailFragment")
//                ?.addToBackStack(null)
//                ?.commit()
//        })
    }

}