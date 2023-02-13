package com.android.testable.myapplication.exercise_10_03

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.android.testable.myapplication.MyApplication
import com.android.testable.myapplication.R

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        findViewById<Button>(R.id.activity_1_button)
            .setOnClickListener {
                (application as MyApplication).synchronizer
                    .executeAfterDelay {
                        startActivity(Activity2.newIntent(this, it))
                    }
            }
    }
}
