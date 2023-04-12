package com.example.whatsappclonet.di

import com.example.whatsappclonet.network.createApplicationService
import org.koin.dsl.module

val networkModule = module{
    single { createApplicationService("https://kitsu.io/api/edge/") }
}