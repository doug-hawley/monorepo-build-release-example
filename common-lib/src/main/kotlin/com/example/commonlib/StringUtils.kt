package com.example.commonlib

object StringUtils {

    fun capitalize(input: String): String {
        if (input.isEmpty()) {
            return input
        }
        return input.replaceFirstChar { it.uppercase() }
    }

    fun truncate(input: String, maxLength: Int): String {
        if (input.length <= maxLength) {
            return input
        }
        return input.take(maxLength) + "..."
    }
}
