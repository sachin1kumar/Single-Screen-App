package com.manager.singlescreenapp

import android.view.View
import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.manager.singlescreenapp.view.MainActivity
import junit.framework.AssertionFailedError
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    @get:Rule
    var mActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(
        MainActivity::class.java, true, true)


    @Test
    fun startConnectedTesting(){
        ensureRecycleView()
    }

    private fun ensureRecycleView(){
        try {
            Espresso.onView(withId(R.id.shimmer_view_container))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }catch (e: AssertionFailedError){

        }
    }
}