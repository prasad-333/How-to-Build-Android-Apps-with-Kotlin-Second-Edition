package com.android.testable.myapplication

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.Mockito.mock
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.math.BigInteger


@RunWith(Parameterized::class)
class NumberAdderParameterNewTest(
    private val input: Int,
    private val expected: BigInteger
) {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun getData(): List<Array<out Any>> = listOf(
            arrayOf(0, BigInteger.ZERO),
            arrayOf(1, BigInteger.ONE),
            arrayOf(5, 15.toBigInteger()),
            arrayOf(20, 210.toBigInteger()),
            arrayOf(Int.MAX_VALUE, BigInteger("2305843008139952128"))
        )
    }
    private val numberAdder = NumberAdderNew()
    @Test
    fun sum() {
        val callback = mock<(BigInteger) -> Unit>()
        numberAdder.sum(input, callback)
        verify(callback).invoke(expected)
    }
}
