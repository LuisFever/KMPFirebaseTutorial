package com.luisfsc.kmpfirebasetutorial

import com.luisfsc.kmpfirebasetutorial.data.AuthRepositoryAndroid
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule : Module = module {
    single<AuthRepository> { AuthRepositoryAndroid() }
}