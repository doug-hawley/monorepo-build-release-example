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

    test("should convert camelCase to snake_case") {
        StringUtils.toSnakeCase("myVariableName") shouldBe "my_variable_name"
    }

    test("should convert spaces and hyphens to underscores") {
        StringUtils.toSnakeCase("some-mixed value") shouldBe "some_mixed_value"
    }

    test("should detect palindromes") {
        StringUtils.isPalindrome("racecar") shouldBe true
    }

    test("should detect palindromes ignoring case and non-alphanumeric characters") {
        StringUtils.isPalindrome("A man, a plan, a canal: Panama") shouldBe true
    }

    test("should return false for non-palindromes") {
        StringUtils.isPalindrome("hello") shouldBe false
    }

    test("should slugify a string") {
        StringUtils.slugify("Hello World!") shouldBe "hello-world"
    }

    test("should collapse multiple spaces and hyphens in slug") {
        StringUtils.slugify("  Too   many   spaces  ") shouldBe "too-many-spaces"
    }

    test("should strip special characters from slug") {
        StringUtils.slugify("Café & Résumé") shouldBe "caf-rsum"
    }
})
