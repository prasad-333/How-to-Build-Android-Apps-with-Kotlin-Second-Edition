package com.android.testable.myapplication.exercise_10_03

import java.util.*


 class RandomizerImpl(private val random: Random): Randomizer{
     override fun getTimeToWait(): Int {
        return random.nextInt(5) + 1
    }
}
