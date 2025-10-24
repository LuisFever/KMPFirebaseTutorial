package com.luisfsc.kmpfirebasetutorial.di

import com.luisfsc.kmpfirebasetutorial.domain.ObserveAuthState
import com.luisfsc.kmpfirebasetutorial.domain.SignInWithEmail
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val authModule = module{
    factory { ObserveAuthState(get()) }
    factoryOf(::SignInWithEmail)
}