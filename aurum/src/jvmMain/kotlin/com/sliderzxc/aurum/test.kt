package com.sliderzxc.aurum

import kotlin.concurrent.thread

public fun main() {
    thread {
        repeat(50) {
            Aurum.d("Log" ,"Test $it")
            Thread.sleep(25)
        }
    }
}