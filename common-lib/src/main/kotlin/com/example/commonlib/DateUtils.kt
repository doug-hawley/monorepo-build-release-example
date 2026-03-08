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

    fun isWeekday(date: LocalDate): Boolean {
        return !isWeekend(date)
    }

    fun daysUntil(from: LocalDate, to: LocalDate): Long {
        return java.time.temporal.ChronoUnit.DAYS.between(from, to)
    }
}
