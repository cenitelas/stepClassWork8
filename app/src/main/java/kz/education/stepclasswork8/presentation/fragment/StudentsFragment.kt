package kz.education.stepclasswork8.presentation.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_students.*
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.domain.StudentsUtilsUseCase
import kz.education.stepclasswork8.presentation.Utils.getAll
import kz.education.stepclasswork8.presentation.Utils.getTop
import kz.education.stepclasswork8.presentation.adapter.StudentsAdapter
import kz.education.stepclasswork8.data.Student
import kz.education.stepclasswork8.presentation.contract.StudentsFragmentContract
import kz.education.stepclasswork8.presentation.presenters.StudentFragmentPresenter

class StudentsFragment : Fragment(), StudentsFragmentContract.View {

    var studentsAdapter: StudentsAdapter? = null;
    var students:ArrayList<Student> = ArrayList()
    lateinit var presenter:StudentFragmentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            val name = bundle.getString("NAME")
            val mark = bundle.getFloat("MARK")
            val group = bundle.getString("GROUP")
            val desk = bundle.getString("DESK")
            students.add(Student(name.toString(),desk.toString(),group.toString(),mark))
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_students, container, false)


        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeLayoutManager()
        initializePresenter()
        initializeAdapter()
        initializeListeners()
        presenter.initializeData()
    }

    override fun initializeLayoutManager(){
        recyclerview_fragment_students?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializePresenter() {
        presenter = StudentFragmentPresenter()
        presenter.attach(this)
    }

    override fun initializeAdapter(){
        studentsAdapter = StudentsAdapter(context,students)
        recyclerview_fragment_students?.adapter = studentsAdapter;
    }

    override fun initiateUpdateAdapter() {
       studentsAdapter?.notifyDataSetChanged()
    }

    override fun processData(students: ArrayList<Student>) {
        this.students.clear()
        this.students.addAll(students)
    }

    override fun initializeListeners(){
        fragment_students_button_sort_by_name?.setOnClickListener(View.OnClickListener {
            StudentsUtilsUseCase().sortByName(students)
            initializeAdapter()
        })

        fragment_students_button_sort_by_mark?.setOnClickListener(View.OnClickListener {
            StudentsUtilsUseCase().sortByMark(students)
            initializeAdapter()
        })

        fragment_students_button_sort_by_group?.setOnClickListener(View.OnClickListener {
            StudentsUtilsUseCase().sortByGroup(students)
            initializeAdapter()
        })

        fragment_students_button_sort_by_random?.setOnClickListener(View.OnClickListener {
            StudentsUtilsUseCase().sortByRandom(students)
            initializeAdapter()
        })

        fragment_students_button_clear_search?.setOnClickListener {
            fragment_students_edit_text_search.setText("")
        }

        fragment_students_button_get_top?.setOnClickListener{
            students.getTop()
            initializeAdapter()
        }

        fragment_students_button_get_all?.setOnClickListener{
            students.getAll()
            initializeAdapter()
        }
        fragment_students_edit_text_search?.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0.toString().isNotEmpty()){
                    fragment_students_button_clear_search.visibility = View.VISIBLE
                }else{
                    fragment_students_button_clear_search.visibility = View.INVISIBLE
                }
                StudentsUtilsUseCase()
                    .searchByName(students,p0.toString())
                initializeAdapter()
            }
        })

        fragment_students_floating_button_add_student?.setOnClickListener {
            val fragmentManager = fragmentManager?.beginTransaction()
            fragmentManager?.replace(R.id.activity_main_relative_layout_fragment_container_students,StudentsCreateFragment())
            fragmentManager?.commit()
        }
    }



    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }
    override fun initializeViews() {
        TODO("Not yet implemented")
    }

}