package com.itmoclimbing.domain.repository

import com.itmoclimbing.domain.model.User

interface UsersRepository {

    fun getAllUsers(): List<User>

}