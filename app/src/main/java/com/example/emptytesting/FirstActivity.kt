package com.example.emptytesting

import android.Manifest
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.Image
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.google.gson.Gson


class FirstActivity : AppCompatActivity() {

    var imageUri: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)


        val jsonString = applicationContext.assets.open("test.json").bufferedReader().use { it.readText() }
        val user = Gson().fromJson(jsonString,User::class.java)
        Log.d("user", "name: ${user.name}, phone: ${user.phone}, email: ${user.email}")

        findViewById<Button>(R.id.btn_wv).setOnClickListener {
            val webViewActivity = Intent(this, WebViewActivity::class.java)
            startActivity(webViewActivity)
        }

        val openGallery = findViewById<Button>(R.id.btn_openGallery)
        val imageView = findViewById<ImageView>(R.id.iv_galleryImage)
        val deleteImage = findViewById<Button>(R.id.btn_deleteImage)
        val number = findViewById<EditText>(R.id.editTextPhone)
        val call = findViewById<Button>(R.id.buttonCall)
        openGallery.setOnClickListener { openGallery() }

        deleteImage.setOnClickListener {
            deleteImage()
        }



    }


    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 11
        private val REQUIRED_PERMISSIONS =
            mutableListOf (
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.CALL_PHONE
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                choosePhotoFromGallary()
 //               callNumber()
            } else {
                Toast.makeText(this,
                    "Permissions not granted by the user.",
                    Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
    private fun openGallery() {
        if (allPermissionsGranted()) {
            choosePhotoFromGallary()
 //           callNumber()
        }
        else {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }

    }

    private fun choosePhotoFromGallary() {
        val galleryIntent = Intent(

            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        galleryIntent.putExtra("s", "ab")
        getResult.launch(galleryIntent)

    }



    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        if (it.resultCode == Activity.RESULT_OK) {
            if (it.data != null) {
                imageUri = it.data!!.dataString.toString()
                val imageView = findViewById<ImageView>(R.id.iv_galleryImage)
                Glide.with(this).load(imageUri).into(imageView)

            }
        }
    }

    private fun deleteImage() {
        if (imageUri!=null) {
            imageUri = null
            val imageView = findViewById<ImageView>(R.id.iv_galleryImage)
            Glide.with(this).load(imageUri).into(imageView)
            Toast.makeText(this, "image deleted", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "no image detected!!", Toast.LENGTH_SHORT).show()

        }
    }

}