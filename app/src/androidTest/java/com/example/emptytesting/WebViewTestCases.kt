package com.example.emptytesting

import android.view.KeyEvent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.web.assertion.WebViewAssertions.webMatches
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms
import androidx.test.espresso.web.webdriver.DriverAtoms.*
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.security.Key

@RunWith(AndroidJUnit4::class)
class WebViewTestCases {

    @get:Rule
    val webViewActivity = ActivityScenarioRule(WebViewActivity::class.java)
    @Test
    fun testWebViewInteraction() {
        onWebView().forceJavascriptEnabled()
    }

    @Test
    fun checkWebElementsTest() {

        onWebView()
            .withElement(findElement(Locator.LINK_TEXT,"http://www.w3.org/2000/svg"))
            .perform(webClick())
        Thread.sleep(3000)


    }


}