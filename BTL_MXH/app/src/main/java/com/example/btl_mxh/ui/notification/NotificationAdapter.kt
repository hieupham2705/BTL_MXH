package com.example.btl_mxh.ui.notification

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemNotificationBinding
import com.example.btl_mxh.model.Notification

class NotificationAdapter(
    private val onclickavartarNotification: () -> Unit
) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    private var listnotification = listOf<Int>()

    class ViewHolder(val binding: ItemNotificationBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNotificationBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.avatarNotification.setImageResource(listnotification[position])
//        holder.binding.textNotification.text = listnotification[position].text
//        holder.binding.root.setBackgroundResource()
        holder.binding.avatarNotification.setOnClickListener {
            onclickavartarNotification.invoke()
        }

    }

    override fun getItemCount(): Int = listnotification.size

    fun setList(list: List<Int>) {
        listnotification = list
    }


}
