package com.example.miniproject_02

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Contact(
    var name: String,
    var phoneNumber: String
): Parcelable {
}