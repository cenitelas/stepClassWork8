package kz.education.stepclasswork8.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Student (
    var name:String,
    var description: String,
    var group : String,
    var mark : Float,
    var show :Boolean
): Parcelable