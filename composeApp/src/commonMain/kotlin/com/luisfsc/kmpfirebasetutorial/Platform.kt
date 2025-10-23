package com.luisfsc.kmpfirebasetutorial

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform