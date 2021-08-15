package com.afdal.pua_3.ui

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.afdal.pua_3.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
class ProfileFragmentTest {
    private lateinit var scenario: FragmentScenario<ProfileFragment>
    @Before
    fun setUp(){
        scenario = launchFragmentInContainer(null, R.style.Theme_PUA_3)
        scenario.moveToState(Lifecycle.State.STARTED)
    }
    @Test
    fun testUserName(){
        onView(withId(R.id.textView)).check(matches(withText("NAME")))
        onView(withId(R.id.tv_name)).check(matches(withText("LOADING......")))
    }
}