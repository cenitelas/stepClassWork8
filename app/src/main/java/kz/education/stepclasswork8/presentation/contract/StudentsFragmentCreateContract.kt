package kz.education.stepclasswork8.presentation.contract

import kz.education.stepclasswork8.data.Student
import kz.education.stepclasswork8.presentation.base.BaseContract

interface StudentsFragmentCreateContract {
    interface View : BaseContract.BaseView{

    }
    interface Presenter : BaseContract.BasePresenter<View>{

    }
}