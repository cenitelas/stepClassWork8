package kz.education.stepclasswork8.presentation.contract

import kz.education.stepclasswork8.data.Student
import kz.education.stepclasswork8.presentation.base.BaseContract

interface StudentsFragmentContract {
    interface View : BaseContract.BaseView{
        fun initializeLayoutManager()
        fun initializePresenter()
        fun initializeAdapter()
        fun initiateUpdateAdapter()
        fun processData(students:ArrayList<Student>)
    }
    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()
    }
}