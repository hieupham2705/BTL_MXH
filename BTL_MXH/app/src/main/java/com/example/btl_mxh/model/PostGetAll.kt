package com.example.btl_mxh.model

import android.os.Parcel
import android.os.Parcelable

data class PostGetAll(
    val status: String,
    val data: Array<Post>,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?:"",
        TODO("data")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PostGetAll> {
        override fun createFromParcel(parcel: Parcel): PostGetAll {
            return PostGetAll(parcel)
        }

        override fun newArray(size: Int): Array<PostGetAll?> {
            return arrayOfNulls(size)
        }
    }
}


