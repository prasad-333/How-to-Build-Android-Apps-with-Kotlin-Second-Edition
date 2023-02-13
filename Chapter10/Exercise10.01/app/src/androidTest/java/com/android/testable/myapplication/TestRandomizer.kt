package com.android.testable.myapplication

import com.android.testable.myapplication.exercise_10_03.Randomizer
import java.util.*

class TestRandomizer : Randomizer {
    override fun getTimeToWait(): Int {
        return 1
        //return  Random().nextInt(5) + 1
    }
}

