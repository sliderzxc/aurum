package com.sliderzxc.aurum

import android.util.Log
import it.czerwinski.kotlin.util.Option
import org.kodein.di.DI

actual object Aurum {
    actual fun d(tag: String, message: String) {
        Log.d(tag, message)
    }
}