package com.example.emptytesting

import android.text.InputType
import android.view.inputmethod.EditorInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.LayoutMatchers.hasEllipsizedText
import androidx.test.espresso.matcher.LayoutMatchers.hasMultilineText
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.CoreMatchers.`is`
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
    fun withIdTest() {

        //working
        val testTextView = onView(withId(R.id.tv_helloWorld))
        val testImageView = onView(withId(R.id.iv_main))
        val testEditText = onView(withId(R.id.et_main))
        val testButton = onView(withId(R.id.btn_main))

        testTextView.check(matches(withId(R.id.tv_helloWorld)))
        testImageView.check(matches(withId(R.id.iv_main)))
        testEditText.check(matches(withId(R.id.et_main)))
        testButton.check(matches(withId(R.id.btn_main)))
    }

    @Test
    fun withContentDescriptionTest() {

        //working
        val testTextView = onView(withId(R.id.tv_helloWorld))
        val testImageView = onView(withId(R.id.iv_main))
        val testEditText = onView(withId(R.id.et_main))
        val testButton = onView(withId(R.id.btn_main))

        testTextView.check(matches(withContentDescription("text")))
        testImageView.check(matches(withContentDescription("image")))
        testEditText.check(matches(withContentDescription("editText")))
        testButton.check(matches(withContentDescription("button")))

    }

    @Test
    fun hasContentDescriptionTest() {
        // working

        val testTextView = onView(withId(R.id.tv_helloWorld))
        val testImageView = onView(withId(R.id.iv_main))
        val testEditText = onView(withId(R.id.et_main))
        val testButton = onView(withId(R.id.btn_main))

        testTextView.check(matches(hasContentDescription()))
        testImageView.check(matches(hasContentDescription()))
        testEditText.check(matches(hasContentDescription()))
        testButton.check(matches(hasContentDescription()))


    }

    @Test
    fun withTagKeyTest() {
        // don't know what tag key is
    }

    @Test
    fun withTagValueTest() {

        //working
        val testTextView = onView(withId(R.id.tv_helloWorld))
        val testImageView = onView(withId(R.id.iv_main))
        val testEditText = onView(withId(R.id.et_main))
        val testButton = onView(withId(R.id.btn_main))


        testTextView.check(matches(withTagValue(`is`("1"))))
        testImageView.check(matches(withTagValue(`is`("2"))))
        testEditText.check(matches(withTagValue(`is`("3"))))
        testButton.check(matches(withTagValue(`is`("4"))))



    }


    @Test
    fun withClassNameTest() {
        //worked
        val testTextView = onView(withId(R.id.tv_helloWorld))
        val testImageView = onView(withId(R.id.iv_main))
        val testEditText = onView(withId(R.id.et_main))
        val testButton = onView(withId(R.id.btn_main))
        testTextView.check(matches(ViewMatchers.withClassName(endsWith("MaterialTextView"))))
        testImageView.check(matches(ViewMatchers.withClassName(endsWith("ImageView"))))
        testEditText.check(matches(ViewMatchers.withClassName(endsWith("EditText"))))
        testButton.check(matches(ViewMatchers.withClassName(endsWith("Button"))))

    }

    @Test
    fun withHintTest() {
        //working
        val testTextView = onView(withId(R.id.tv_helloWorld))
        val testImageView = onView(withId(R.id.iv_main))
        val testEditText = onView(withId(R.id.et_main))
        val testButton = onView(withId(R.id.btn_main))
        testTextView.check(matches(withHint("Some")))
        testEditText.check(matches(withHint("Enter something")))
        testButton.check(matches(withHint("Button Hint")))

    }
    @Test
    fun withInputTypeTest() {
        //this only used  for editText
        val testEditText = onView(withId(R.id.et_main))
        testEditText.check(matches(withInputType(InputType.TYPE_CLASS_DATETIME)))

    }

    @Test
    fun withResourceNameTest() {
        //working
        // resource name is the id of the view
        val test = onView(withResourceName("cl_main"))
            test.check(matches(isDisplayed()))

        val testTextView = onView((withResourceName("tv_helloWorld")))
        val testImageView = onView((withResourceName("iv_main")))
        val testEditText = onView((withResourceName("et_main")))
        val testButton = onView(withResourceName("btn_main"))
        testTextView.check(matches(isDisplayed()))
        testImageView.check(matches(isDisplayed()))
        testEditText.check(matches(isDisplayed()))
        testButton.check(matches(isDisplayed()))

    }

    @Test
    fun withAlphaValueTest() {
        //working
        //it test the percentage of view displayed
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(withAlpha(0.9F)))

        val testTextView = onView(withId(R.id.tv_helloWorld))
        val testImageView = onView(withId(R.id.iv_main))
        val testEditText = onView(withId(R.id.et_main))
        val testButton = onView(withId(R.id.btn_main))
        testTextView.check(matches(withAlpha(0.9F)))
        testImageView.check(matches(withAlpha(1F)))
        testEditText.check(matches(withAlpha(1F)))
        testButton.check(matches(withAlpha(1F)))

    }

    @Test
    fun withEffectiveVisibilityTest() {
        //WORKING
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(ViewMatchers.withEffectiveVisibility(Visibility.INVISIBLE)))
    }

    @Test
    fun withSpinnerTextTest() {
        //to test later
    }

    @Test
    fun withSubStringTest() {
        //working
        //work for view having text attribute
//        val test = onView(withId(R.id.btn_main))
        val testTextView = onView(withId(R.id.tv_helloWorld))

//        test.check(matches(withSubstring("u")))
        testTextView.check(matches(withSubstring("W")))

    }

    @Test
    fun hasLinksTest() {
      //not working yet
        // it only works for textView
        val testTextView = onView(withId(R.id.tv_helloWorld))
        testTextView.check(matches(hasLinks()))


    }

    @Test
    fun hasTextColorTest() {
        //working
        val test = onView(allOf(
            withId(R.id.tv_helloWorld),
            hasTextColor(R.color.black)
        ))
        test.check(matches(isDisplayed()))
    }

    @Test
    fun hasEllipsizedTextTest() {
        //working fine
        val test = onView(withId(R.id.tv_ellipsizeText))
        test.check(matches(hasEllipsizedText()))

        // not working if it dont have ellipsized text,it will not work just by having ellipsize attribute
//        val editTextTest = onView(withId(R.id.et_main))
//        editTextTest.check(matches(hasEllipsizedText()))

    }

    @Test
    fun hasMultilineTextTest() {
        //working and works for textview only

        val multilineTextTest = onView(withId(R.id.tv_multilineText))
        multilineTextTest.check(matches(hasMultilineText()))

        //doesn't work for editText
//        val multilineEditTextTest = onView(withId(R.id.et_main))
//        multilineEditTextTest.check(matches(hasMultilineText()))

    }

    @Test
    fun hasBackGroundTest() {
        // not working

        val res = InstrumentationRegistry.getInstrumentation().context.getDrawable(R.drawable.bg_test)
        val test = onView(withId(R.id.tv_multilineText))
    }

    @Test
    fun hasErrorTextTest() {
        //working
        // only for editText
        val test = onView(withId(R.id.et_main))
        test.check(matches(hasErrorText("This field is required")))
    }

    @Test
    fun hasImeActionTest() {
        // working
        //only for editText
        val test = onView(withId(R.id.et_main))
        test.check(matches(hasImeAction(EditorInfo.IME_ACTION_NEXT)))
    }

    @Test
    fun supportsInputsMethodsTest() {
        //working

        //works only for edittext
        val etTest = onView(withId(R.id.et_main))
        etTest.check(matches(supportsInputMethods()))
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
        val test = onView(withId(R.id.tv_multilineText))
        test.check(matches(isDisplayingAtLeast(80)))

    }

    @Test
    fun isCompleteDisplayedTest() {
        //working
        val test = onView(withId(R.id.tv_ellipsizeText))
        test.check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun isEnabledTest() {
        //working
        val test = onView(withId(R.id.tv_multilineText))
        test.check(matches(isEnabled()))
    }

    @Test
    fun isFocusableTest() {
        //working
        val test = onView(withId(R.id.tv_multilineText))
        test.check(matches(isFocusable()))
    }

    @Test
    fun hasFocusTest() {
        //will test on edittext
        //working
        val test = onView(withId(R.id.et_main))
        test.perform(typeText("has Focus"))
        test.check(matches(hasFocus()))
    }

    @Test
    fun isClickableTest() {
        //working
        val test = onView(withId(R.id.et_main))
        test.check(matches(isClickable()))
    }

    @Test
    fun isSelectableTest() {
        //will work on selectable view
        //not working
        val test = onView(withId(R.id.et_main))
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
        val test = onView(allOf(
            withParent(withId(R.id.cl_main)),
            withChild(withId(R.id.tv_helloWorld))
        ))
    }

    @Test
    fun hasSiblingTest() {
        //working still have to test
        val test = onView(withId(R.id.tv_helloWorld))
        test.check(matches(hasSibling(withId(R.id.iv_main))))

    }

    @Test
    fun withChildTest() {
        //working
        val test = onView(withId(R.id.cl_main))
        test.check(matches(withChild(withId(R.id.ll_main))))
    }

    @Test
    fun hasChildCountTest() {
        //working
        val test = onView(withId(R.id.cl_main))
        test.check(matches(hasChildCount(4)))
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



    @Test
    fun tyepTextTest() {
        val test = onView(withId(R.id.et_main))

        test.perform(typeText("any string"))
    }




}
