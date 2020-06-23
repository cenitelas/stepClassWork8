package kz.education.stepclasswork8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

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
            currentFragment = StudentsFragment()

            fragmentMenager.beginTransaction()
                .add(R.id.activity_main_relative_layout_fragment_container_students,currentFragment!!)
                .addToBackStack(currentFragment!!::class.java.name)
                .commit()

        }
    }
}