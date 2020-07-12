package kz.education.stepclasswork8.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Note (
    var date:String,
    var name:String,
    var text: String
): Parcelable