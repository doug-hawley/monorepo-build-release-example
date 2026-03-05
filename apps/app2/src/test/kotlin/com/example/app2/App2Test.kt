package com.example.app2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class App2Test : FunSpec({

    test("should broadcast to all recipients") {
        // given
        val app = App2()
        val recipients = listOf("user1@example.com", "user2@example.com", "user3@example.com")
        // when
        val count = app.broadcast(recipients, "System update")
        // then
        count shouldBe 3
    }
})
