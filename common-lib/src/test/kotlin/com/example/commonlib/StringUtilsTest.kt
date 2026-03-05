package com.example.commonlib

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringUtilsTest : FunSpec({

    test("should capitalize first letter") {
        // given
        val input = "hello"
        // when
        val result = StringUtils.capitalize(input)
        // then
        result shouldBe "Hello"
    }

    test("should return empty string when input is empty") {
        // given
        val input = ""
        // when
        val result = StringUtils.capitalize(input)
        // then
        result shouldBe ""
    }

    test("should truncate long strings") {
        // given
        val input = "hello world"
        // when
        val result = StringUtils.truncate(input, 5)
        // then
        result shouldBe "hello..."
    }

    test("should not truncate short strings") {
        // given
        val input = "hi"
        // when
        val result = StringUtils.truncate(input, 5)
        // then
        result shouldBe "hi"
    }
})
