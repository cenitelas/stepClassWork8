package kz.education.stepclasswork8.presentation.activity

import NotesFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.presentation.fragment.StudentsCreateFragment
import kz.education.stepclasswork8.presentation.fragment.StudentsFragment

class MainActivity : AppCompatActivity() {

    lateinit var fragmentMenager : FragmentManager

    var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeFragmentManager()
        initializeDefaultFragment()
    }

    fun initializeFragmentManager(){
        fragmentMenager = supportFragmentManager

    }

    fun initializeDefaultFragment(){
        if(currentFragment==null){
            currentFragment =
                NotesFragment()

            fragmentMenager.beginTransaction()
                .add(R.id.activity_main_relative_layout_fragment_container_students,currentFragment!!,"NotesFragment")
                .commit()

        }
    }
}