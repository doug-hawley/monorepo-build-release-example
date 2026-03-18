package com.example.module2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
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

    test("should find notifications by recipient") {
        // given
        val service = NotificationService()
        service.send("alice@example.com", "Hello Alice")
        service.send("bob@example.com", "Hello Bob")
        service.send("alice@example.com", "Another for Alice")
        // when
        val results = service.findByRecipient("alice@example.com")
        // then
        results shouldHaveSize 2
    }

    test("should return empty list for unknown recipient") {
        // given
        val service = NotificationService()
        service.send("alice@example.com", "Hello")
        // when
        val results = service.findByRecipient("nobody@example.com")
        // then
        results shouldHaveSize 0
    }

    test("should reject blank recipient") {
        // given
        val service = NotificationService()
        // when/then
        shouldThrow<IllegalArgumentException> {
            service.send(" ", "Hello")
        }
    }

    test("should reject blank message") {
        // given
        val service = NotificationService()
        // when/then
        shouldThrow<IllegalArgumentException> {
            service.send("user@example.com", " ")
        }
    }
})
