package com.example.commonlib

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateUtils {

    private val ISO_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE

    fun formatDate(date: LocalDate): String {
        return date.format(ISO_FORMATTER)
    }

    fun isWeekend(date: LocalDate): Boolean {
        return date.dayOfWeek.value >= 6
    }
}
