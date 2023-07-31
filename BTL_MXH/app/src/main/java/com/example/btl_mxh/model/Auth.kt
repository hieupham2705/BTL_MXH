package com.example.btl_mxh.model

import android.os.Parcel
import android.os.Parcelable

data class Auth(
    val createdDate: String,
    val lastModifiedDate: String,
    val id: String,
    val email: String,
    val fullName: String,
    val username: String,
    val phone: String,
    val gender: Any?,
    val avatar: Any?,
    val birthday: Any?,
    val roleName: String,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        TODO("gender"),
        TODO("avatar"),
        TODO("birthday"),
        parcel.readString()?:"",
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(createdDate)
        parcel.writeString(lastModifiedDate)
        parcel.writeString(id)
        parcel.writeString(email)
        parcel.writeString(fullName)
        parcel.writeString(username)
        parcel.writeString(phone)
        parcel.writeString(roleName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Auth> {
        override fun createFromParcel(parcel: Parcel): Auth {
            return Auth(parcel)
        }

        override fun newArray(size: Int): Array<Auth?> {
            return arrayOfNulls(size)
        }
    }
}
