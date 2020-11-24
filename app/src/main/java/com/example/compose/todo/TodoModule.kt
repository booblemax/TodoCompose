package com.example.compose.todo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val todoModule = module {

    viewModel { TodoViewModel() }

}