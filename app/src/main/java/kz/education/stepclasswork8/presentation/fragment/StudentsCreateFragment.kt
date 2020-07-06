package kz.education.stepclasswork8.presentation.fragment

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_students_create.*
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.data.Student
import kz.education.stepclasswork8.presentation.contract.StudentsFragmentCreateContract

class StudentsCreateFragment : Fragment(), StudentsFragmentCreateContract.View {
    val IMAGE_CAPTURE_CODE = 1231
    val PERMISSION_CODE = 1230
    var imageUri: Uri? = null

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

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()
        initializeViews()
    }

    override fun initializeViews() {
        fragment_students_create_image_view_avatar?.setImageDrawable(ContextCompat.getDrawable(view?.context!!,R.drawable.ic_preview))
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initializeListeners(){
        fragment_students_create_button_cancel.setOnClickListener{
            val fragmentManager = fragmentManager
            fragmentManager?.popBackStack()
        }

        fragment_students_create_image_view_avatar?.setOnClickListener(View.OnClickListener {
            if(!initiateCheckPermissionCamera())
                initiateRequestPermissionsCamera()
            else
                initiateCamera()
        })

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
                        imageUri.toString(),
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

    @RequiresApi(Build.VERSION_CODES.M)
    fun initiateRequestPermissionsCamera(){
        requestPermissions(Array(1){android.Manifest.permission.CAMERA},PERMISSION_CODE)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initiateCheckPermissionCamera() :Boolean{
        return  activity?.checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

    fun initiateCamera(){
        val values = ContentValues()
        imageUri = activity?.contentResolver?.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //called when image was captured from camera intent
        when(requestCode){
            IMAGE_CAPTURE_CODE-> {
                if(resultCode == Activity.RESULT_OK) {
                    fragment_students_create_image_view_avatar?.setImageURI(imageUri)
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