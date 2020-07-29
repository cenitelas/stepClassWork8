package kz.education.stepclasswork8.presentation.viewholder

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.data.Student
import kz.education.stepclasswork8.presentation.adapter.StudentsAdapter
import kz.education.stepclasswork8.presentation.fragment.StudentsCreateFragment
import java.text.ParsePosition

class StudentsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textViewName:TextView? = null;
    var textViewDescription:TextView? = null;
    var textViewGroup:TextView? = null;
    var textViewMark:TextView? = null;
    var layout:LinearLayout? = null;

    init {
        initializeViews()
    }

    fun initializeViews(){
        textViewName = itemView.findViewById(R.id.viewholder_students_text_view_name)
        textViewDescription = itemView.findViewById(R.id.viewholder_students_text_view_description)
        textViewGroup = itemView.findViewById(R.id.viewholder_student_text_view_group)
        textViewMark = itemView.findViewById(R.id.viewholder_students_text_view_mark)
        layout = itemView.findViewById(R.id.viewholder_student_layout)
    }

    fun initiateBind(student: Student, listener: StudentsAdapter.Listener, position: Int){
        textViewName?.setText(student.name)
        textViewDescription?.setText(student.description)
        textViewGroup?.setText(student.group)
        textViewMark?.setText(student.mark.toString())
        itemView.setOnClickListener{ listener.onItemClick(student) }
    }
}