package com.example.compose

import android.app.Application
import com.example.compose.todo.todoModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@ExperimentalCoroutinesApi
class TooApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@TooApp)

            modules(todoModule)
        }
    }
}