package com.example.module1

import com.example.commonlib.StringUtils

class UserService {

    private val users = mutableMapOf<String, User>()

    fun createUser(id: String, name: String, email: String): User {
        require(name.isNotBlank()) { "Name must not be blank" }
        require(email.contains("@")) { "Email must contain @" }
        val user = User(
            id = id,
            name = StringUtils.capitalize(name),
            email = email.lowercase()
        )
        users[id] = user
        return user
    }

    fun findUser(id: String): User? {
        return users[id]
    }

    fun listUsers(): List<User> {
        return users.values.toList()
    }

    fun deleteUser(id: String): Boolean {
        return users.remove(id) != null
    }
}
