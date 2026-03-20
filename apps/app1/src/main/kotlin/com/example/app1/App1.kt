package com.example.app1

import com.example.module1.UserService
import com.example.module2.NotificationService

class App1 {

    private val userService = UserService()
    private val notificationService = NotificationService()

    fun greet(name: String): String {
        return "Hello, $name! Welcome to App1."
    }

    fun goodbye(name: String): String {
        return "Goodbye, $name! Thanks for using App1."
    }

    fun registerAndNotify(name: String, email: String): String {
        val user = userService.createUser(
            id = System.nanoTime().toString(),
            name = name,
            email = email
        )
        val notification = notificationService.send(
            recipient = user.email,
            message = "Welcome, ${user.name}!"
        )
        return "User ${user.name} registered and notified (notification ${notification.id})"
    }
}
