package com.example.btl_mxh.ui.profile

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.databinding.ItemAddImageBinding
import com.example.btl_mxh.databinding.ItemImageProfileBinding
import com.example.btl_mxh.utils.extension.loadImageFromUrl
import com.example.btl_mxh.utils.extension.openDialogNotification
import com.example.btl_mxh.utils.extension.showImage

private const val TAG = "ImageProfileAdapter"
class ImageProfileAdapter(
    private val context: Context
) : RecyclerView.Adapter<ImageProfileAdapter.ViewHolder>(){
    private val listImage = mutableListOf<String>()
    class ViewHolder(val binding : ItemAddImageBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAddImageBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listImage.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imvGalleryPhoto.loadImageFromUrl(listImage[position])
        holder.binding.imvGalleryPhoto.setOnClickListener {
            context?.let {
                val dialogQuestion = Dialog(it)
                dialogQuestion.showImage(listImage[position])
            }
        }
    }
    fun setListImage(list : List<String>){
        Log.e(TAG, "setListImage: $list", )
        listImage.clear()
        listImage.addAll(list)
        notifyDataSetChanged()
    }
}