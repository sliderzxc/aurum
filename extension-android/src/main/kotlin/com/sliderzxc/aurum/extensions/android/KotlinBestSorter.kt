package com.sliderzxc.aurum.extensions.android

/**
 * Kotlin best sorter
 *
 * @constructor Create empty Kotlin best sorter
 */
object KotlinBestSorter {
    fun bubbleSomeSort(arr: IntArray): IntArray {
        val n = arr.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
        return arr
    }
}