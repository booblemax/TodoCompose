package com.example.compose.todo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
class TodoViewModel : ViewModel() {

    private var _todoItems = MutableStateFlow<List<TodoItem>>(listOf())
    val todoItems: StateFlow<List<TodoItem>> get() = _todoItems

    fun addItem(item: TodoItem) {
        val items = _todoItems.value.toMutableList()
        items.add(item)
        _todoItems.value = items
    }

    fun removeItem(item: TodoItem) {
        val items = _todoItems.value.toMutableList()
        items.remove(item)
        _todoItems.value = items
    }
}