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

    fun toSnakeCase(input: String): String {
        return input
            .replace(Regex("([a-z])([A-Z])"), "$1_$2")
            .replace(Regex("[\\s-]+"), "_")
            .lowercase()
    }

    fun toCamelCase(input: String): String {
        return input
            .split(Regex("[\\s_-]+"))
            .filter { it.isNotEmpty() }
            .mapIndexed { index, word ->
                if (index == 0) word.lowercase()
                else word.lowercase().replaceFirstChar { it.uppercase() }
            }
            .joinToString("")
    }

    fun reverse(input: String): String {
        return input.reversed()
    }

    fun isPalindrome(input: String): Boolean {
        val normalized = input.lowercase().filter { it.isLetterOrDigit() }
        return normalized == normalized.reversed()
    }

    fun slugify(input: String): String {
        return input
            .lowercase()
            .replace(Regex("[^a-z0-9\\s-]"), "")
            .replace(Regex("\\s+"), "-")
            .replace(Regex("-+"), "-")
            .trim('-')
    }
}
