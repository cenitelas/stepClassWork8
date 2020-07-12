import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_note_create.*
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.data.Note
import kz.education.stepclasswork8.presentation.contract.NoteFragmentCreateContract
import java.util.*

class NoteFragmentCreate : Fragment(), NoteFragmentCreateContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_note_create, container, false)
        return view;
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()
        initializeViews()
    }

    override fun initializeViews() {

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initializeListeners(){
        fragment_note_create_button_cancel.setOnClickListener{
            val fragmentManager = fragmentManager
            fragmentManager?.popBackStack()
        }


        fragment_note_create_button_add.setOnClickListener{
            when {
                fragment_note_create_edit_text_name.text.toString().isEmpty() -> {
                    fragment_note_create_text_view_error.setText("Fill in all the fields")
                }
                fragment_note_create_edit_text_text.text.toString().isEmpty() -> {
                    fragment_note_create_text_view_error.setText("Fill in all the fields")
                }
                else -> {
                    val arguments = Bundle()
                    var note : Note = Note(
                        Date().toGMTString(),
                        fragment_note_create_edit_text_name.text.toString(),
                        fragment_note_create_edit_text_text.text.toString()
                    )
                    arguments.putParcelable("NOTE",note)
                    val fragment = fragmentManager?.findFragmentByTag("NotesFragment") as NotesFragment
                    fragment.presenter.addNote(note,fragment.notes)
                    val fragmentManager = fragmentManager
                    fragmentManager?.popBackStack()
                }
            }
        }
    }

    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }
}