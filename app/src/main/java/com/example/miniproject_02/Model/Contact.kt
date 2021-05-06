package com.example.miniproject_02.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Contact(
    @PrimaryKey (autoGenerate = true)
    val id:Int = 0,
    val name: String,
    val phoneNumber: String
): Parcelable {
}