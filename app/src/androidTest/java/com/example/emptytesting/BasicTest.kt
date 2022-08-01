package com.example.emptytesting

import android.text.InputType
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.endsWith
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class BasicTest {

    @Rule @JvmField
    val mainActivityTest = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainBasicTest() {

        val test1 = onView(withId(R.id.tv_helloWorld))
        test1.check(matches(isDisplayed()))

        val test2 = onView(withText("Hello World!"))
        test2.check(matches(isDisplayed()))

        val test3 = onView(allOf(withId(R.id.tv_helloWorld), withText("Hello World!"), isDisplayed()))
        test3.check(matches(withText("Hello World!")))

        val test4 = onView(
            allOf(
                withId(R.id.tv_helloWorld),
                withText("Hello World!"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        test4.check(matches(withText("Hello World!")))


    }

    @Test
    fun withContentDescription() {

        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(withContentDescription("ab")))

    }

    @Test
    fun hasContentDescription() {
        // has some problems right now
        onView(allOf(
            withId(R.id.tv_helloWorld),

        ))
    }

    @Test
    fun withTagKey() {

        //not working
    }

    @Test
    fun withClassName() {
        //worked
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(ViewMatchers.withClassName(endsWith("MaterialTextView"))))
    }

    @Test
    fun withInputType() {
        //not worked yet
        val test = onView(withInputType(InputType.TYPE_NULL))
        test.check(matches(withId(R.id.tv_helloWorld)))
    }

    @Test
    fun withResourceName() {
        //not worked yet
        val test = onView(withResourceName("colors"))
            test.check(matches(isDisplayed()))
    }

    @Test
    fun withAlphaValue() {
        //working
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(withAlpha(0.9F)))
    }

    @Test
    fun withEffectiveVisibility() {
        //WORKING
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(ViewMatchers.withEffectiveVisibility(Visibility.INVISIBLE)))
    }

    @Test
    fun withSpinnerText() {
        //to test later
    }

    @Test
    fun withSubString() {
        //working
        val test = onView(withId(R.id.cl_main))
        test.check(matches(withSubstring("c")))
    }

    @Test
    fun hasLinks() {
      //not working yet

    }

    @Test
    fun hasTextColor() {
        val test = onView(ViewMatchers.hasTextColor(R.color.purple_500))
        test.check(matches(isDisplayed()))
    }

    @Test
    fun hasEllipsizedText() {
        //not working
        val test = onView(withId(R.id.tv_helloWorld))
    }

    @Test
    fun hasMultilineText() {
        //not working

    }

    @Test
    fun hasBackGround() {
        // not working
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(hasBackground(R.drawable.bg_test)))
    }

    @Test
    fun hasErrorText() {
        //will test in edittext
    }

    @Test
    fun hasImeAction() {
        // will test in edittext
    }

    @Test
    fun supportsInputsMethods() {
        //working
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(supportsInputMethods()))
    }

    @Test
    fun isRootTest() {
        // not working
        val test = onView(withId(R.id.cl_main))
        test.check(matches(isRoot()))
    }

    @Test
    fun isDisplayedAtLeast() {
        //working
        val test = onView(withId(R.id.cl_main))
        test.check(matches(isDisplayingAtLeast(80)))

    }

    @Test
    fun isCompleteDisplayedTest() {
        //working
        val test = onView(withId(R.id.cl_main))
        test.check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun isEnabledTest() {
        //working
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(isEnabled()))
    }

    @Test
    fun isFocusableTest() {
        //working
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(isFocusable()))
    }

    @Test
    fun hasFocusTest() {
        //will test on edittext
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(hasFocus()))
    }

    @Test
    fun isClickableTest() {
        //working
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(isClickable()))
    }

    @Test
    fun isSelectableTest() {
        //will work on selectable view
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(isSelected()))
    }

    @Test
    fun isCheckableTest() {
        //will work on checkable view
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(isChecked()))
    }

    @Test
    fun isNotCheckedTest() {
        //will work on check view
        val test = onView(withId(R.id.tv_helloWorld))
    }

    @Test
    fun isJavaScriptEnabledTest() {
        //will work on webview
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(isJavascriptEnabled()))
    }

    @Test
    fun withParentTest() {
        //working
        val test = onView(withId(R.id.cl_main))
        test.check(matches(withParent(withId(R.id.tv_helloWorld))))
    }

    @Test
    fun hasSiblingTest() {
        //working still have to test
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(hasSibling(withId(R.id.tv_helloWorld))))
    }

    @Test
    fun withChildTest() {
        //working
        val test = onView(withId(R.id.cl_main))
        test.check(matches(withChild(withId(R.id.tv_helloWorld))))
    }

    @Test
    fun hasChildCountTest() {
        //working
        val test = onView(withId(R.id.cl_main))
        test.check(matches(hasChildCount(2)))
    }

    @Test
    fun hasMinimumChildCountTest() {
        //working
        val test = onView(withId(R.id.cl_main))
        test.check(matches(hasMinimumChildCount(1)))
    }

    @Test
    fun hasDescendantTest() {
        //working
        val test = onView(withId(R.id.cl_main))
        test.check(matches(hasDescendant(withId(R.id.tv_helloWorld))))

    }

    @Test
    fun hasDescendantOfATest() {
        //working
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(isDescendantOfA(withId(R.id.cl_main))))

    }







}
