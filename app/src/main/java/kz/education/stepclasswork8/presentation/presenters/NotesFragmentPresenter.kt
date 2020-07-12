package kz.education.stepclasswork8.presentation.presenters

import kz.education.stepclasswork8.data.Note
import kz.education.stepclasswork8.presentation.base.BaseContract
import kz.education.stepclasswork8.presentation.contract.NotesFragmentContract
import java.util.*
import kotlin.collections.ArrayList

class NotesFragmentPresenter : NotesFragmentContract.Presenter {

    var view:NotesFragmentContract.View? = null;
    override fun initializeData() {
        view?.processData(ArrayList<Note>().apply {
            add(Note(Date().toGMTString(),"Заметка 1","Тут будет текст заментки 1=)"))
            add(Note(Date(2020,4,20).toGMTString(),"Заметка 1","Тут будет текст заментки 1=)"))
            add(Note(Date(2020,4,20).toGMTString(),"Заметка 1","Тут будет текст заментки 1=)"))
        })
        view?.initializeAdapter()
    }

    override fun attach(view: NotesFragmentContract.View) {
        this.view = view
    }

    override fun addNote(note: Note,notes:ArrayList<Note>) {
        notes.add(note)
        view?.initializeAdapter()
    }
    override fun onStop() {
        view = null
    }
}