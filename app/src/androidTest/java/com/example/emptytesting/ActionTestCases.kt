package com.example.emptytesting

import android.net.Uri
import android.view.KeyEvent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.core.Is.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActionTestCases {

    @Rule @JvmField
    val mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

//    @Rule @JvmField
//    val firstActivityScenarioRule = ActivityScenarioRule(FirstActivity::class.java)
    @Test
    fun typeTextTest() {

        //working

        val etMain = onView(withId(R.id.et_main))
        etMain.perform(typeText("Espresso Test Cases"))

    }

    @Test
    fun typeTextFocusedViewTest() {

        //working it will type text in non_empty editText
        val etMain = onView(withId(R.id.et_main))

        etMain.perform(typeText("Espresso Test Cases"))

        etMain.perform(typeTextIntoFocusedView("Espresso Test Cases"))

    }

    @Test
    fun replaceTextTest() {

        //working
        val etMain = onView(withId(R.id.et_main))

        etMain.perform(typeText("Espresso Test Cases"))
        etMain.perform(replaceText("Replacing previous text"))
    }

    @Test
    fun clearTextTest() {

        //working
        val etMain = onView(withId(R.id.et_main))
  //      etMain.perform(typeText("Espresso Test Cases"))
        etMain.perform(clearText())
    }

    @Test
    fun pressKeyTest() {
        //working
        val etMain = onView(withId(R.id.et_main))
        etMain.perform(typeText("Some Text"))
        etMain.perform(pressKey(KeyEvent.KEYCODE_SPACE))
    }

    @Test
    fun pressMenuKeyTest() {
        //working
        val etMain = onView(withId(R.id.et_main))
        etMain.perform(typeText("Press Menu Key"))
        etMain.perform(pressMenuKey())
    }

    @Test
    fun closeSoftKeyBoardTest() {
        //working
        val etMain = onView(withId(R.id.et_main))
        etMain.perform(typeText("Some Text"))
        etMain.perform(pressKey(KeyEvent.KEYCODE_SPACE))
        etMain.perform(closeSoftKeyboard())
        Thread.sleep(2000)
    }

    @Test
    fun clickTest() {
        //working
        val btnMain = onView(withId(R.id.btn_main))
        btnMain.perform(click())
    }


    @Test
    fun doubleClickTest() {
        //working
        val btnMain = onView(withId(R.id.iv_main))
        btnMain.perform(doubleClick())
    }

    @Test
    fun longClickTest() {
        //working
        val btnMain = onView(withId(R.id.iv_main))
        btnMain.perform(longClick())
    }

    @Test
    fun pressBackTest() {
        //working
        val btnMain = onView(withId(R.id.btn_main))
        btnMain.perform(click())
        Espresso.pressBack()


    }

    @Test
    fun pressBackUnconditionallyTest() {
        //working
        val btnMain = onView(withId(R.id.btn_main))
        btnMain.perform(click())
        Espresso.pressBackUnconditionally()

    }

    @Test
    fun openLinkTest() {
        //working
        //you have to set autolink web in view
        val test = onView(withId(R.id.tv_openLinks))
        test.perform(scrollTo())
        test.check(matches(isDisplayed()))
        Thread.sleep(1000)
        test.perform(
            openLink(containsString("google"), `is`(Uri.parse("https://www.google.com/")))
        )

//        test.perform(openLink(containsString("stack"), `is`(Uri.parse( "https://stackoverflow.com/questions/2734270/how-to-make-links-in-a-textview-clickable"))))

    }

    @Test
    fun openLinkWithTextTest() {

        val test = onView(withId(R.id.tv_openLinks))
        test.perform(scrollTo())
        test.perform(openLinkWithText("https://www.google.com/"))
    }

    @Test
    fun openLinkWithUriTest() {

        val test = onView(withId(R.id.tv_openLinks))
        test.perform(scrollTo())
        test.perform(openLinkWithText("https://www.google.com/"))
    }

    @Test
    fun pressImeActionButtonTest() {

        val test = onView(withId(R.id.et_main))
        test.perform(pressImeActionButton())
        Thread.sleep(2000)
    }

    @Test
    fun scrollToTest() {
        val test = onView(withId(R.id.et_mainSecond))
        test.perform(scrollTo())
        Thread.sleep(1000)
        onView(withId(R.id.tv_helloWorld)).perform(scrollTo())
    }

    @Test
    fun swipeDownTest() {
        onView(withId(R.id.cl_main)).perform(swipeDown())
    }

    @Test
    fun swipeUpTest() {
        onView(withId(R.id.cl_main)).perform(swipeUp())
    }
    @Test
    fun swipeLeftTest() {
        onView(withId(R.id.cl_main)).perform(swipeLeft())
    }
    @Test
    fun swipeRightTest() {
        onView(withId(R.id.cl_main)).perform(swipeRight())
    }

}