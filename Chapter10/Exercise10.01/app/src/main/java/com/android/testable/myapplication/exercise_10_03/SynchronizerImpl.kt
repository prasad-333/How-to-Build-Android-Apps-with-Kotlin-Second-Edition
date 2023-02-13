package com.android.testable.myapplication.exercise_10_03

import java.util.*

//class SynchronizerImpl (
//    private val randomizer: Randomizer,
//    private val timer: Timer,
//    private val countingIdlingResource: CountingIdlingResource
//) {
//    fun executeAfterDelay(callback: (Int) -> Unit) {
//        val timeToWait = randomizer.getTimeToWait()
//        countingIdlingResource.increment()
//        timer.schedule(CallbackTask(callback, timeToWait), timeToWait * 1000L)
//    }
//    inner class CallbackTask(
//        private val callback: (Int) -> Unit,
//        private val time: Int
//    ) : TimerTask() {
//        override fun run() {
//            callback(time)
//            countingIdlingResource.decrement()
//        }
//    }
//}

class SynchronizerImpl(
    private val randomizer: Randomizer,
    private val timer: Timer
) : Synchronizer {
    override fun executeAfterDelay(callback: (Int) -> Unit) {
        val timeToWait = randomizer.getTimeToWait()
        timer.schedule(CallbackTask(callback, timeToWait), timeToWait * 1000L)
    }


    inner class CallbackTask(
        private val callback: (Int) -> Unit,
        private val time: Int
    ) : TimerTask() {
        override fun run() {
            callback(time)
        }
    }
}

