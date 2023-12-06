package com.sliderzxc.aurum

import kotlinx.uuid.UUID

import it.czerwinski.kotlin.util.Option

actual object Aurum {
    actual fun d(tag: String, message: String) {
        console.log(message)
    }
}