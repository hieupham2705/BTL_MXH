package com.example.btl_mxh.model

import android.os.Parcel
import android.os.Parcelable

data class RegisterEntity(
    val email: String,
    var password: String,
    val fullName: String,
    val username: String,
    val phone: String,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeString(password)
        parcel.writeString(fullName)
        parcel.writeString(username)
        parcel.writeString(phone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RegisterEntity> {
        override fun createFromParcel(parcel: Parcel): RegisterEntity {
            return RegisterEntity(parcel)
        }

        override fun newArray(size: Int): Array<RegisterEntity?> {
            return arrayOfNulls(size)
        }
    }
}
