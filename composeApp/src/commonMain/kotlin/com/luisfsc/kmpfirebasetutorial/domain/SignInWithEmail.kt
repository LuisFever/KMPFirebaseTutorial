package com.luisfsc.kmpfirebasetutorial.domain

import com.luisfsc.kmpfirebasetutorial.AuthRepository

class SignInWithEmail(private val repository: AuthRepository){
    suspend operator fun invoke(user: String, password: String) = repository.signInWithEmail(user, password)
}

