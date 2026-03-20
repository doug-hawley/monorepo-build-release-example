package com.example.app2

import com.example.module2.NotificationService

class App2 {

    private val notificationService = NotificationService()

    fun broadcastUrgent(recipients: List<String>, message: String): BroadcastSummary {
        return broadcast(recipients, "[URGENT] $message")
    }

    fun broadcastToGroup(groupName: String, recipients: List<String>, message: String): BroadcastSummary {
        return broadcast(recipients, "[$groupName] $message")
    }

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
) {
    val status: String
        get() = if (totalSent == recipients.size) "complete" else "partial"
}
