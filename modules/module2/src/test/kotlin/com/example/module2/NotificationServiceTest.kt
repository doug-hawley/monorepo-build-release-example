package com.example.module2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class NotificationServiceTest : FunSpec({

    test("should send notification") {
        // given
        val service = NotificationService()
        // when
        val notification = service.send("user@example.com", "Hello!")
        // then
        notification.sent shouldBe true
        notification.recipient shouldBe "user@example.com"
    }

    test("should truncate long messages") {
        // given
        val service = NotificationService()
        val longMessage = "a".repeat(200)
        // when
        val notification = service.send("user@example.com", longMessage)
        // then
        notification.message.length shouldBe 103 // 100 + "..."
    }

    test("should count sent notifications") {
        // given
        val service = NotificationService()
        service.send("user1@example.com", "Hello")
        service.send("user2@example.com", "World")
        // when
        val count = service.countSent()
        // then
        count shouldBe 2
    }
})
