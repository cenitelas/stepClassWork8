package kz.education.stepclasswork8.presentation.viewholder
import android.annotation.SuppressLint
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.data.Note
import java.util.*


class NotesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textViewName:TextView? = null;
    var textViewData:TextView? = null;
    var textViewText:TextView? = null;
    var layout: LinearLayout? = null;
    init {
        initializeViews()
    }

    fun initializeViews(){
        textViewName = itemView.findViewById(R.id.viewholder_notes_text_view_name)
        textViewData = itemView.findViewById(R.id.viewholder_notes_text_view_date)
        textViewText = itemView.findViewById(R.id.viewholder_notes_text_view_text)
        layout = itemView.findViewById(R.id.viewholder_notes_layout)
    }

    @SuppressLint("ResourceAsColor")
    fun initiateBind(note: Note){
        textViewName?.setText(note.name)
        textViewData?.setText(note.date)
        textViewText?.setText(note.text)
        if(Date(note.date).year == Date().year && Date(note.date).date==Date().date && Date(note.date).month==Date().month){
            layout?.setBackgroundColor(R.color.red)
        }
    }
}