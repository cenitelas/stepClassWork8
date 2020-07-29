import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_notes.*
import kz.education.stepclasswork8.R
import kz.education.stepclasswork8.data.Note
import kz.education.stepclasswork8.presentation.adapter.NoteAdapter
import kz.education.stepclasswork8.presentation.contract.NotesFragmentContract
import kz.education.stepclasswork8.presentation.presenters.NotesFragmentPresenter


class NotesFragment : Fragment(), NotesFragmentContract.View {

    var notesAdapter: NoteAdapter? = null;
    var notes:ArrayList<Note> = ArrayList()
    lateinit var presenter:NotesFragmentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            val note = bundle.getParcelable<Note>("NOTE")
            note?.let { notes.add(it) }
        }

    }
   

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_notes, container, false)


        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeLayoutManager()
        initializePresenter()
        initializeAdapter()
        initializeListeners()
        presenter.initializeData()
    }

    override fun initializeLayoutManager(){
        recyclerview_fragment_notes?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializePresenter() {
        presenter = NotesFragmentPresenter()
        presenter.attach(this)
    }

    override fun initializeAdapter(){
        notesAdapter = NoteAdapter(context,notes)
        recyclerview_fragment_notes?.adapter = notesAdapter;
    }

    override fun initiateUpdateAdapter() {
        notesAdapter?.notifyDataSetChanged()
    }

    override fun processData(notes: ArrayList<Note>) {
        this.notes.clear()
        this.notes.addAll(notes)
    }

    override fun initializeListeners(){
        fragment_notes_floating_button_add_note?.setOnClickListener {
            val fragmentManager = fragmentManager
            fragmentManager?.beginTransaction()?.add(R.id.activity_main_relative_layout_fragment_container_students,NoteFragmentCreate(),"NoteCreateFragment")
                ?.addToBackStack(null)
                ?.commit()
        }
    }


    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }
    override fun initializeViews() {
        TODO("Not yet implemented")
    }

}