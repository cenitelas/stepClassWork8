package kz.education.stepclasswork8.presentation.contract

import kz.education.stepclasswork8.data.Note
import kz.education.stepclasswork8.presentation.base.BaseContract

interface NotesFragmentContract {
    interface View : BaseContract.BaseView{
        fun initializeLayoutManager()
        fun initializePresenter()
        fun initializeAdapter()
        fun initiateUpdateAdapter()
        fun processData(notes:ArrayList<Note>)
    }
    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()
        fun addNote(note:Note,notes:ArrayList<Note>)
    }
}