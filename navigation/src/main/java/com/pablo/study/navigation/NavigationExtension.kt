package com.pablo.study.navigation

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment

fun Fragment.startNewActivity(intent: Intent) {
    startActivity(intent)
}


fun Activity.startNewActivity(intent: Intent) {
    startActivity(intent)
}


fun Activity.startNewActivityAndFinish(intent: Intent) {
    startActivity(intent)
    finish()
}