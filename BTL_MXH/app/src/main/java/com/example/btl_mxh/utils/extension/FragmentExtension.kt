package com.example.btl_mxh.utils.extension

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.btl_mxh.R


fun Fragment.showToast(mess: String) {
    val toast = Toast(context)
    toast.duration = Toast.LENGTH_LONG
    val inflater: LayoutInflater =
        context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val view: View = inflater.inflate(R.layout.custom_toast_layout, null)
    val customToastTextView = view.findViewById<TextView>(R.id.textViewToast)
    customToastTextView.text = mess
    toast.setView(view)
    toast.show()

}
