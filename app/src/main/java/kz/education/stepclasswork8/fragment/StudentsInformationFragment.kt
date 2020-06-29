package kz.education.stepclasswork8.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_students_information.*
import kz.education.stepclasswork8.R

class StudentsInformationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_students_information, container, false)
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()
    }

    fun initializeListeners(){
        fragment_students_information_button_cancel.setOnClickListener{
            val fragmentManager = fragmentManager?.beginTransaction()
            fragmentManager?.replace(R.id.activity_main_relative_layout_fragment_container_students,StudentsFragment())
            fragmentManager?.commit()
        }

        fragment_students_information_button_add.setOnClickListener{
            when {
                fragment_students_information_edit_text_fio.text.toString().isEmpty() -> {
                    fragment_students_information_text_view_error.setText("Fill in all the fields")
                }
                fragment_students_information_edit_text_mark.text.toString().isEmpty() -> {
                    fragment_students_information_text_view_error.setText("Fill in all the fields")
                }
                fragment_students_information_edit_text_group.text.toString().isEmpty() -> {
                    fragment_students_information_text_view_error.setText("Fill in all the fields")
                }
                fragment_students_information_edit_text_detail.text.toString().isEmpty() -> {
                    fragment_students_information_text_view_error.setText("Fill in all the fields")
                }
                else -> {
                    val arguments = Bundle()
                    arguments.putString("NAME", fragment_students_information_edit_text_fio.text.toString())
                    arguments.putFloat("MARK", fragment_students_information_edit_text_mark.text.toString().toFloat())
                    arguments.putString("GROUP", fragment_students_information_edit_text_group.text.toString())
                    arguments.putString("DESK", fragment_students_information_edit_text_detail.text.toString())
                    val fragment = StudentsFragment();
                    fragment.arguments = arguments;
                    val fragmentManager = fragmentManager?.beginTransaction()
                    fragmentManager?.replace(R.id.activity_main_relative_layout_fragment_container_students,fragment)
                    fragmentManager?.commit()
                }
            }
        }
    }
}