package com.android.testable.myapplication.exercise_10_04

class Adder {
//    fun sum(n: Int): Int = 0

    //normal function
//    fun sum(n: Int): Long {
//        var result = 0L
//        for (i in 1..n) {
//            result += i
//        }
//        return result
//    }

    //Optimized function
//    fun sum(n: Int): Long {
//        return (n * (n.toLong() + 1)) / 2
//    }

    //handle error condition
    fun sum(n: Int): Long {
        return if (n > 0) (n * (n.toLong() + 1)) / 2 else -1
    }



}
