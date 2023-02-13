package com.android.testable.myapplication

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class MyApplicationTestRunner : AndroidJUnitRunner() {
    @Throws(Exception::class)
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application? {
        return super.newApplication(cl, TestMyApplication::class.java.name, context)
    }
}
