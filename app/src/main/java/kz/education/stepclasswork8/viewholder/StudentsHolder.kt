package kz.education.stepclasswork8.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.data.Student
import org.w3c.dom.Text

class StudentsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textViewName:TextView? = null;
    var textViewDescription:TextView? = null;
    var textViewGroup:TextView? = null;

    init {
        initializeViews()
    }

    fun initializeViews(){
        textViewName = itemView.findViewById(R.id.viewholder_students_text_view_name)
        textViewDescription = itemView.findViewById(R.id.viewholder_students_text_view_description)
        textViewGroup = itemView.findViewById(R.id.viewholder_student_text_view_group)
    }

    fun initiateBind(student: Student){
        textViewName?.setText(student.name)
        textViewDescription?.setText(student.description)
        textViewGroup?.setText(student.group)
    }
}