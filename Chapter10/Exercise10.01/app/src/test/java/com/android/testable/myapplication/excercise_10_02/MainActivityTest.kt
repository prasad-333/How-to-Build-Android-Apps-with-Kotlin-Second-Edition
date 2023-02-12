package com.android.testable.myapplication.excercise_10_02

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.testable.myapplication.R
//import org.mockito.ArgumentMatchers.matches

@RunWith(AndroidJUnit4::class)
class MainActivityTest {


    @Test
    fun `show sum result in text view`() {
        val scenario = launch(MainActivity::class.java)


        scenario.moveToState(Lifecycle.State.RESUMED)


        scenario.onActivity { activity ->
            onView(withId(R.id.edit_text)).perform(replaceText("5"))
            onView(withId(R.id.button)).perform(click())
            onView(withId(R.id.text_view)).check(matches(withText(activity.getString(R.string.the_sum_of_numbers_from_1_to_is, 5, "15"))))
        }
    }


    @Test
    fun `show error in text view`() {
        val scenario = launch(MainActivity::class.java)

        scenario.moveToState(Lifecycle.State.RESUMED)


        scenario.onActivity { activity ->
            onView(withId(R.id.edit_text)).perform(replaceText("-5"))
            onView(withId(R.id.button)).perform(click())
            onView(withId(R.id.text_view)).check(matches(withText(activity.getString(R.string.error_invalid_number))))
        }
    }
}
