package kz.education.stepclasswork8.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_students_create.*
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.data.Student
import kz.education.stepclasswork8.presentation.contract.StudentsFragmentCreateContract

class StudentsCreateFragment : Fragment(), StudentsFragmentCreateContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_students_create, container, false)
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()
    }

    override fun initializeViews() {
        TODO("Not yet implemented")
    }

    override fun initializeListeners(){
        fragment_students_create_button_cancel.setOnClickListener{
            val fragmentManager = fragmentManager
            fragmentManager?.popBackStack()
        }

        fragment_students_create_button_add.setOnClickListener{
            when {
                fragment_students_create_edit_text_fio.text.toString().isEmpty() -> {
                    fragment_students_create_text_view_error.setText("Fill in all the fields")
                }
                fragment_students_create_edit_text_mark.text.toString().isEmpty() -> {
                    fragment_students_create_text_view_error.setText("Fill in all the fields")
                }
                fragment_students_create_edit_text_group.text.toString().isEmpty() -> {
                    fragment_students_create_text_view_error.setText("Fill in all the fields")
                }
                fragment_students_create_edit_text_detail.text.toString().isEmpty() -> {
                    fragment_students_create_text_view_error.setText("Fill in all the fields")
                }
                else -> {
                    val arguments = Bundle()
                    var student : Student = Student(
                        fragment_students_create_edit_text_fio.text.toString(),
                        fragment_students_create_edit_text_detail.text.toString(),
                        fragment_students_create_edit_text_group.text.toString(),
                        fragment_students_create_edit_text_mark.text.toString().toFloat(),
                        true
                    )
                    arguments.putParcelable("STUDENT",student)
                    val fragment = fragmentManager?.findFragmentByTag("StudentFragment") as StudentsFragment
                    fragment.presenter.addStudent(student,fragment.students)
                    val fragmentManager = fragmentManager
                    fragmentManager?.popBackStack()
                }
            }
        }
    }

    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }
}