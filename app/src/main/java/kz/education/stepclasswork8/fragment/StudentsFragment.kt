package kz.education.stepclasswork8.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.adapter.StudentsAdapter
import kz.education.stepclasswork8.data.Student

class StudentsFragment : Fragment() {

    var recyclerViewStudents:RecyclerView? = null;
    var studentsAdapter: StudentsAdapter? = null;
    var students:ArrayList<Student> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_students, container, false)
        initializeViews(view)
        initializeData()
        initializeLayoutManager()
        initializeAdapter()
        return view;
    }

    fun initializeLayoutManager(){
        recyclerViewStudents?.layoutManager = LinearLayoutManager(context)
    }

    fun initializeViews(view:View){
        recyclerViewStudents = view.findViewById(R.id.recyclerview_fragment_students)
    }

    fun initializeAdapter(){
        studentsAdapter = StudentsAdapter(context,students)
        recyclerViewStudents?.adapter = studentsAdapter;
    }

    fun initializeData(){
        students.add(Student("Pasha","STudent 2","GROUP 1"))
        students.add(Student("Sasha","STudent 1","GROUP 1"))
        students.add(Student("Pasha","STudent 2","GROUP 2"))
        students.add(Student("Sasha","STudent 1","GROUP 1"))
        students.add(Student("Pasha","STudent 2","GROUP 2"))
        students.sortBy{e->e.group}
    }
}