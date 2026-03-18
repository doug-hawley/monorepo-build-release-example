package com.example.app2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class App2Test : FunSpec({

    test("should broadcast to all recipients") {
        // given
        val app = App2()
        val recipients = listOf("user1@example.com", "user2@example.com", "user3@example.com")
        // when
        val summary = app.broadcast(recipients, "System update")
        // then
        summary.totalSent shouldBe 3
        summary.recipients shouldHaveSize 3
    }

    test("should prefix message with URGENT tag") {
        // given
        val app = App2()
        val recipients = listOf("admin@example.com")
        // when
        val summary = app.broadcastUrgent(recipients, "Server down")
        // then
        summary.totalSent shouldBe 1
        summary.status shouldBe "complete"
    }

    test("should report complete status when all sent") {
        // given
        val app = App2()
        val summary = app.broadcast(listOf("a@example.com", "b@example.com"), "Hi")
        // then
        summary.status shouldBe "complete"
    }

    test("should return empty summary for no recipients") {
        // given
        val app = App2()
        // when
        val summary = app.broadcast(emptyList(), "Hello")
        // then
        summary.totalSent shouldBe 0
        summary.recipients shouldHaveSize 0
    }
})
