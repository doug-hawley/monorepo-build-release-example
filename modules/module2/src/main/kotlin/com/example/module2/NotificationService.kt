package com.example.module2

import com.example.commonlib.StringUtils

class NotificationService {

    private val notifications = mutableListOf<Notification>()

    fun send(recipient: String, message: String): Notification {
        require(recipient.isNotBlank()) { "Recipient must not be blank" }
        require(message.isNotBlank()) { "Message must not be blank" }
        val notification = Notification(
            id = (notifications.size + 1).toString(),
            recipient = recipient,
            message = StringUtils.truncate(message, 100),
            sent = true
        )
        notifications.add(notification)
        return notification
    }

    fun listNotifications(): List<Notification> {
        return notifications.toList()
    }

    fun countSent(): Int {
        return notifications.count { it.sent }
    }

    fun findByRecipient(recipient: String): List<Notification> {
        return notifications.filter { it.recipient == recipient }
    }
}
