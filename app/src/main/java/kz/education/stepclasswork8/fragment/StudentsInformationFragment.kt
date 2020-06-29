package kz.education.stepclasswork8.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kz.education.stepclasswork8.R

class StudentsInformationFragment : Fragment() {
    var imageViewAvatar: ImageView? = null;
    var textViewFio: TextView? = null;
    var textViewDetail: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_students_information, container, false)
        initializeViews(view);
        return view;
    }

    fun initializeViews(view:View){
        imageViewAvatar = view.findViewById(R.id.fragment_students_information_image_view_avatar)
        textViewFio = view.findViewById(R.id.fragment_students_information_text_view_fio)
        textViewDetail = view.findViewById(R.id.fragment_students_information_text_view_detail)
    }
}