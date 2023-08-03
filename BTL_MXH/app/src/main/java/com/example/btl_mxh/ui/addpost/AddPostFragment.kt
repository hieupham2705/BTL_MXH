package com.example.btl_mxh.ui.addpost

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentAddTextBinding
import com.example.btl_mxh.ui.profile.viewModel
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

private const val TAG = "AddTextFragment"

class AddPostFragment : BaseFragment<FragmentAddTextBinding>(FragmentAddTextBinding::inflate) {

    private lateinit var galleryLauncher: ActivityResultLauncher<Intent>
    private lateinit var pngFilePath: List<String>
    private val adapterPost by lazy { AdapterImage() }
    override val viewModel by viewModel<AddPostViewModel>()

    override fun initData() {

    }
    override fun handleEvent() {
        binding.apply {
            imvAddImage.setOnClickListener {
                openGallery()
            }
            post.setOnClickListener {
                Log.e(TAG, pngFilePath.toString())
                viewModel.createNewPost(
                    edtCaption.text.toString(),
                    pngFilePath as ArrayList<String>
                )
            }
        }
    }

    override fun bindData() {
        viewModel.stageCreateNewPost.observe(viewLifecycleOwner) {
            Log.e(TAG, it.toString())
            findNavController().navigate(R.id.action_addTextFragment_to_homeFragment)
        }
        binding.recyclerview.layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
        binding.recyclerview.adapter = adapterPost
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        galleryLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data: Intent? = result.data
                    // Xử lý dữ liệu ảnh ở đây
                    if (data != null) {
                        val imageUris = arrayListOf<Uri>()
                        if (data.clipData != null) {
                            // Người dùng đã chọn nhiều ảnh
                            val clipData = data.clipData
                            for (i in 0 until clipData!!.itemCount) {
                                val uri = clipData.getItemAt(i).uri
                                imageUris.add(uri)

                            }
                        } else if (data.data != null) {
                            // Người dùng đã chọn một ảnh
                            val uri = data.data
                            imageUris.add(uri!!)
                        }
                        // Sử dụng imageUris để làm gì đó với các ảnh đã chọn
                        pngFilePath = convertUrisToPngs(context!!.contentResolver, imageUris)
                        Log.e(TAG,imageUris.toString())
                        adapterPost.setAdapter(imageUris)

                    }
                }
            }
    }

    // Hàm mở cửa sổ chọn ảnh
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        galleryLauncher.launch(intent)
    }

    fun convertUrisToPngs(contentResolver: ContentResolver, uris: List<Uri>): List<String> {
        val pngPaths = mutableListOf<String>()
        for (uri in uris) {
            val pngPath = uriToJpg(contentResolver, uri)
            pngPath?.let {
                pngPaths.add(it)
            }
        }
        return pngPaths
    }

    fun uriToJpg(contentResolver: ContentResolver, uri: Uri): String? {
        try {
            val inputStream = contentResolver.openInputStream(uri)
            inputStream?.use {
                // Chuyển đổi dữ liệu của tập tin ảnh thành đối tượng Bitmap
                val bitmap = BitmapFactory.decodeStream(inputStream)

                // Tạo một tập tin mới với định dạng JPG trong thư mục lưu trữ ngoài của ứng dụng
                val storageDir = context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                val file = File.createTempFile("image", ".jpg", storageDir)

                // Ghi dữ liệu của Bitmap vào tập tin mới với định dạng JPG
                val outputStream: OutputStream = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                outputStream.flush()
                outputStream.close()

                return file.absolutePath
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

}