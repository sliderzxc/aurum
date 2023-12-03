package com.sliderzxc.aurum

import com.sliderzxc.aurum.color.LogColor
import java.text.SimpleDateFormat
import java.util.Calendar

public actual object Aurum {

    @Suppress("SimpleDateFormat")
    public actual fun d(tag: String, message: String) {
        val dateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS")
        val timeStamp = dateFormat.format(Calendar.getInstance().time)
        val coloredMessage = "${LogColor.RED.code}$timeStamp | $tag | $message"
        println(coloredMessage)
    }
}
