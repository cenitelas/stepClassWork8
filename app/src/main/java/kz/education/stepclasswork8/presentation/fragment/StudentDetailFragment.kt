package kz.education.stepclasswork8.presentation.fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.data.Student

class StudentDetailFragment : Fragment() {

    var student:Student? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            student = it.getParcelable("STUDENT")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view);
    }

    fun initializeViews(view:View){
        if(student?.avatar!!.isNotEmpty()){
            fragment_students_detail_image_view_avatar?.setImageURI(Uri.parse(student?.avatar))
        }else{
            fragment_students_detail_image_view_avatar?.setImageDrawable(ContextCompat.getDrawable(view.context,R.drawable.ic_preview))
        }

        fragment_students_detail_text_view_first_name?.text = "${getText(R.string.viewholder_students_text_view_name)}: ${student?.name}"
        fragment_students_detail_text_view_detail?.text = "${getText(R.string.viewholder_students_text_view_description)}: ${student?.description}"
    }
}
