package com.example.emptytesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert
import junit.framework.TestCase.assertEquals
import org.hamcrest.CoreMatchers.endsWith
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AssertionTestCases {

    @get:Rule
    val firstActivityScenarioRule = ActivityScenarioRule(FirstActivity::class.java)


    @Test
    fun assertViewTest() {

        val editText = "First Activity"
        val result = MyCustomMatchers().getText(onView(withId(R.id.tv_first)))

        Assert.assertTrue("Not matched",editText == result )
    }
}