package com.android.testable.myapplication.exercise_10_03

interface Synchronizer {
    fun executeAfterDelay(callback: (Int) -> Unit)
}
