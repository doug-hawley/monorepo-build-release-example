package com.example.module1

import io.kotest.core.spec.style.FunSpec
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class UserServiceTest : FunSpec({

    test("should create user with capitalized name") {
        // given
        val service = UserService()
        // when
        val user = service.createUser("1", "john", "JOHN@EXAMPLE.COM")
        // then
        user.name shouldBe "John"
        user.email shouldBe "john@example.com"
    }

    test("should find user by id") {
        // given
        val service = UserService()
        service.createUser("1", "john", "john@example.com")
        // when
        val user = service.findUser("1")
        // then
        user shouldNotBe null
        user?.name shouldBe "John"
    }

    test("should find user by email") {
        // given
        val service = UserService()
        service.createUser("1", "alice", "Alice@Example.com")
        // when
        val user = service.findByEmail("alice@example.com")
        // then
        user shouldNotBe null
        user?.name shouldBe "Alice"
    }

    test("should return null for unknown email") {
        // given
        val service = UserService()
        // when
        val user = service.findByEmail("nobody@example.com")
        // then
        user shouldBe null
    }

    test("should list all users") {
        // given
        val service = UserService()
        service.createUser("1", "alice", "alice@example.com")
        service.createUser("2", "bob", "bob@example.com")
        // when
        val users = service.listUsers()
        // then
        users shouldHaveSize 2
    }

    test("should reject blank name") {
        // given
        val service = UserService()
        // when/then
        shouldThrow<IllegalArgumentException> {
            service.createUser("1", " ", "user@example.com")
        }
    }

    test("should delete existing user") {
        // given
        val service = UserService()
        service.createUser("1", "alice", "alice@example.com")
        // when
        val deleted = service.deleteUser("1")
        // then
        deleted shouldBe true
        service.findUser("1") shouldBe null
    }

    test("should return false when deleting non-existent user") {
        // given
        val service = UserService()
        // when
        val deleted = service.deleteUser("999")
        // then
        deleted shouldBe false
    }

    test("should reject invalid email") {
        // given
        val service = UserService()
        // when/then
        shouldThrow<IllegalArgumentException> {
            service.createUser("1", "alice", "invalid-email")
        }
    }
})
