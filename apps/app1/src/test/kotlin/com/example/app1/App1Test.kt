package com.example.app1

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldContain

class App1Test : FunSpec({

    test("should register user and send notification") {
        // given
        val app = App1()
        // when
        val result = app.registerAndNotify("alice", "alice@example.com")
        // then
        result shouldContain "Alice"
        result shouldContain "registered and notified"
    }
})
