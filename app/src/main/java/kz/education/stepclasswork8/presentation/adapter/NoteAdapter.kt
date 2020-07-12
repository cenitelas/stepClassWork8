package kz.education.stepclasswork8.presentation.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.data.Note
import kz.education.stepclasswork8.presentation.activity.MainActivity
import kz.education.stepclasswork8.presentation.fragment.StudentDetailFragment
import kz.education.stepclasswork8.presentation.viewholder.NotesHolder


class NoteAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var context : Context? = null
    var notes:ArrayList<Note>

    constructor(context: Context?,notes:ArrayList<Note>){
        this.context=context;
        this.notes= notes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.viewholder_notes,parent,false)
        return NotesHolder(view)
    }

    override fun getItemCount(): Int {
        return this.notes.size ?:0
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NotesHolder).initiateBind(notes.get(position))
    }

}