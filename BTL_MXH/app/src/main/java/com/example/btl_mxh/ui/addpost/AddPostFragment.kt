package com.example.btl_mxh.ui.addpost

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btl_mxh.R
import com.example.btl_mxh.base.BaseFragment
import com.example.btl_mxh.databinding.FragmentAddTextBinding
import com.example.btl_mxh.utils.extension.showToast
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

private const val TAG = "AddTextFragment"

class AddPostFragment : BaseFragment<FragmentAddTextBinding>(FragmentAddTextBinding::inflate) {

    private lateinit var galleryLauncher: ActivityResultLauncher<Intent>
    private var pngFilePath: List<String>? = null
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
                val textPart = RequestBody.create(
                    "caption/plain".toMediaTypeOrNull(),
                    edtCaption.text.toString()
                )
                val imageFiles: List<File>? = null
                val imageRequestBodyList = mutableListOf<MultipartBody.Part>()
                if (pngFilePath != null) {
                    pngFilePath?.forEach { image ->
                        val imageFile = File(image)
                        val imageRequestBody = imageFile.asRequestBody("image/*".toMediaType())
                        val imagePart = MultipartBody.Part.createFormData(
                            "image",
                            imageFile.name,
                            imageRequestBody
                        )
                        imageRequestBodyList.add(imagePart)
                    }
                }

                viewModel.createNewPost(
                    textPart,
                    imageRequestBodyList
                )
            }
        }
    }

    override fun bindData() {
        viewModel.stageCreateNewPost.observe(viewLifecycleOwner) {
            Log.e(TAG, it.toString())
            showToast("success")
            findNavController().navigate(R.id.action_addTextFragment_to_homeFragment)
        }
        viewModel.isError.observe(viewLifecycleOwner) {
            showToast(it)
        }
        binding.recyclerview.layoutManager =
            GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
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
                        Log.e(TAG, imageUris.toString())
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