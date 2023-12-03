package com.sliderzxc.aurum

import android.util.Log

public actual object Aurum {
    public actual fun d(tag: String, message: String) {
        Log.d(tag, message)
    }
}