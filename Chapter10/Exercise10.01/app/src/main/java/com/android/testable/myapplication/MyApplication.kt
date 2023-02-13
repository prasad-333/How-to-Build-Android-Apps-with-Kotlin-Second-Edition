package com.android.testable.myapplication

import android.app.Application
import com.android.testable.myapplication.exercise_10_03.Randomizer
import com.android.testable.myapplication.exercise_10_03.RandomizerImpl
import com.android.testable.myapplication.exercise_10_03.Synchronizer
import com.android.testable.myapplication.exercise_10_03.SynchronizerImpl
import java.util.*


//class MyApplication : Application() {
//    val countingIdlingResource = CountingIdlingResource("Timer resource")
//    val randomizer = Randomizer(Random())
//    val synchronizer = Synchronizer(randomizer, Timer(), countingIdlingResource)
//}

open class MyApplication : Application() {


    lateinit var synchronizer: Synchronizer


    override fun onCreate() {
        super.onCreate()
        synchronizer = createSynchronizer()


    }


    open fun createRandomizer(): Randomizer = RandomizerImpl(Random())


    open fun createSynchronizer(): Synchronizer = SynchronizerImpl(createRandomizer(), Timer())
}

