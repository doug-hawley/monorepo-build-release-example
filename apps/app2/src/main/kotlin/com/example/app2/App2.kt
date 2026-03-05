package com.example.app2

import com.example.module2.NotificationService

class App2 {

    private val notificationService = NotificationService()

    fun broadcast(recipients: List<String>, message: String): BroadcastSummary {
        recipients.forEach { recipient ->
            notificationService.send(recipient, message)
        }
        return BroadcastSummary(
            totalSent = notificationService.countSent(),
            recipients = recipients
        )
    }
}

data class BroadcastSummary(
    val totalSent: Int,
    val recipients: List<String>
)
