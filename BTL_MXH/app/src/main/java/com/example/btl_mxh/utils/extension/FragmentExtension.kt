package com.example.btl_mxh.utils.extension

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(mess: String) {
    Toast.makeText(requireContext(), mess, Toast.LENGTH_LONG).show()
}