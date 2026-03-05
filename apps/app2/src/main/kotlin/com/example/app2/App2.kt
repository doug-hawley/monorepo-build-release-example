package com.example.app2

import com.example.module2.NotificationService

class App2 {

    private val notificationService = NotificationService()

    fun broadcast(recipients: List<String>, message: String): Int {
        recipients.forEach { recipient ->
            notificationService.send(recipient, message)
        }
        return notificationService.countSent()
    }
}
