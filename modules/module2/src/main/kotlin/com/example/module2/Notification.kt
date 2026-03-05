package com.example.module2

data class Notification(
    val id: String,
    val recipient: String,
    val message: String,
    val sent: Boolean = false
)
