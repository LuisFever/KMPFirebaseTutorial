package com.luisfsc.kmpfirebasetutorial.domain

import com.luisfsc.kmpfirebasetutorial.AuthRepository

class ObserveAuthState(private val repository: AuthRepository){
    operator fun invoke() = repository.authState
}