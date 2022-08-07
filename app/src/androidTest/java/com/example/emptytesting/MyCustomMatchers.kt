package com.example.emptytesting

import android.view.View
import android.widget.TextView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import org.hamcrest.Matcher

class MyCustomMatchers {

    fun getText(viewInteraction: ViewInteraction): String {

        lateinit var text : String

        viewInteraction.perform(object : ViewAction {

            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(TextView::class.java)
            }

            override fun getDescription(): String {
                return "Text of the view"
            }

            override fun perform(uiController: UiController?, view: View?) {
                val textView = view as TextView
                text = textView.text.trim().toString()
            }

        })

        return text

    }
}