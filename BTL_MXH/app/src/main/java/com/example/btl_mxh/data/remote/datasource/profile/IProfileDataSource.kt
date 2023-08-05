package com.example.btl_mxh.data.remote.datasource.profile

import com.example.btl_mxh.base.BaseResponse
import com.example.btl_mxh.model.UpdateProfiledata
import java.io.File

interface IProfileDataSource {
    interface Local {
    }

    interface Remote {
        suspend fun updateProfile(
            birthday : String,
            gender : String,
            avatar : File,
            fullName : String,
            username : String,
            email : String
        ):BaseResponse<UpdateProfiledata>
    }
}