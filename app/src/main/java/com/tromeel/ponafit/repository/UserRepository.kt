package com.tromeel.ponafit.repository

import com.tromeel.ponafit.data.UserDao
import com.tromeel.ponafit.model.User


class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}