package com.example.emptytesting

import android.Manifest
import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.view.KeyEvent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import com.bumptech.glide.Glide
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginFlowTestCases {


    @get:Rule
    val loginActivity = ActivityScenarioRule(LoginActivity::class.java)

    @get:Rule
    var grantGalleryPermission: GrantPermissionRule = GrantPermissionRule.grant(Manifest.permission.READ_EXTERNAL_STORAGE)



    @Test
    fun loginFlow() {

        onView(withId(R.id.et_userName)).perform(typeText("Abhishek"))
        onView(withId(R.id.et_userPassword)).perform(typeText("123456"))
        Espresso.closeSoftKeyboard()
        Thread.sleep(3000)
        pressImeActionButton()

        onView(
            allOf(
                withId(R.id.btn_submit),
                isEnabled(),
                isDisplayed()
            )
        )

        onView(withId(R.id.btn_submit)).perform(click())
        Thread.sleep(2000)
        onView(
            allOf(
                withId(R.id.btn_main),
                isDisplayed(),

            )
        ).perform(click())
        onView(withId(R.id.first_activity)).check(matches(isDisplayed()))
        Thread.sleep(2000)

        onView(withId(R.id.btn_wv)).check(matches(isDisplayed())).perform(click())

        Thread.sleep(2000)

        Espresso.pressBack()

        Thread.sleep(1000)

        onView(withId(R.id.btn_openGallery)).check(matches(isDisplayed())).perform(click())

    }

    @After
    fun checkImage() {
        onView(withId(R.id.iv_galleryImage)).check(matches(MyCustomMatchers().hasDrawable()))

    }




}