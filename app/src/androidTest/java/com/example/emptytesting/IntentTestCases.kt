package com.example.emptytesting

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.allOf
import org.junit.*
import org.junit.runner.RunWith
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class IntentTestCases {


     val intent = Intent(ApplicationProvider.getApplicationContext(),FirstActivity::class.java)

    @get:Rule
    val firstActivityRule = ActivityTestRule(FirstActivity::class.java)

//    @Rule
//    val grantPermissionRule = GrantPermissionRule.grant(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    @Before
    fun initIntent() {
        Intents.init()
    }
    @Test
    fun intendedTest(){


        val expectedIntent = allOf(
            hasAction(Intent.ACTION_PICK),
            hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        )
        onView(withId(R.id.btn_openGallery)).perform(click())
        intended(expectedIntent)
    }


    @Test
    fun intendingTest() {

        val expectedIntent = allOf(
            hasAction(Intent.ACTION_PICK),
            hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        )

//        savePickedImage(firstActivityRule.activity)
        val imageGalleryResult = createImageGallerySetResultStub(firstActivityRule.activity)
        intending(expectedIntent).respondWith(imageGalleryResult)
        onView(withId(R.id.btn_openGallery)).perform(click())

    }

    fun savePickedImage(activity: Activity) {
        val resources = InstrumentationRegistry.getInstrumentation().context.resources
        val bm = BitmapFactory.decodeResource( resources, R.mipmap.ic_launcher)
        val dir = activity.externalCacheDir
        val file = File(dir?.path, "pickImageResult.jpeg")
        val outStream: FileOutputStream?
        try {
            outStream = FileOutputStream(file)
            bm.compress(Bitmap.CompressFormat.JPEG, 100, outStream)
            with(outStream) {
                flush()
                close()
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }



    fun createImageGallerySetResultStub(activity: Activity): Instrumentation.ActivityResult {
        val imageUri = Uri.parse("some_random")
        val resultData = Intent()
        resultData.data = imageUri
        val result = Instrumentation.ActivityResult(
            Activity.RESULT_OK, resultData
        )
        return result
    }


    @After
    fun closeIntent() {
        Intents.release()
    }

}