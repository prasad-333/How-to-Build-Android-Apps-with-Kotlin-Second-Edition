package com.android.testable.myapplication

import androidx.test.espresso.idling.CountingIdlingResource
import com.android.testable.myapplication.exercise_10_03.Randomizer
import com.android.testable.myapplication.exercise_10_03.Synchronizer
import java.util.*

//class TestMyApplication : MyApplication() {
//    override fun createRandomizer(): Randomizer {
//        return TestRandomizer()
//    }
//}


class TestMyApplication : MyApplication() {


    val countingIdlingResource = CountingIdlingResource("Timer resource")


    override fun createRandomizer(): Randomizer {
        return TestRandomizer()
    }


    override fun createSynchronizer(): Synchronizer {
        return TestSynchronizer(super.createSynchronizer(), countingIdlingResource)
    }
}
