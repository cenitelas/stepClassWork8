package kz.education.stepclasswork8.presentation.presenters

import kz.education.stepclasswork8.data.Student
import kz.education.stepclasswork8.presentation.base.BaseContract
import kz.education.stepclasswork8.presentation.contract.StudentsFragmentContract

class StudentFragmentPresenter : StudentsFragmentContract.Presenter {

    var view:StudentsFragmentContract.View? = null;
    override fun initializeData() {
        view?.processData(ArrayList<Student>().apply {
            add(Student("Pasha","STudent 1","GROUP 1",5F))
            add(Student("Sasha","STudent 2","GROUP 1",4F))
            add(Student("Kesha","STudent 3","GROUP 2",5F))
            add(Student("Dasha","STudent 4","GROUP 1",3F))
            add(Student("Masha","STudent 5","GROUP 2",2F))
        })
        view?.initializeAdapter()
    }

    override fun attach(view: StudentsFragmentContract.View) {
        this.view = view
    }


    override fun onStop() {
        view = null
    }
}