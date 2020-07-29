package kz.education.stepclasswork8.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

abstract class BaseDialog: DialogFragment() {

    var currentView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        currentView = LayoutInflater.from(context).inflate(initializeLayout(), container, false)
        return currentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun initializeLayout(): Int

    abstract fun getDialogTag(): String

    abstract fun setDialogMargin(marginTop: Int, marginBottom: Int, marginStart: Int, marginEnd: Int)
}