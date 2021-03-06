package com.example.compose.todo

import androidx.compose.ui.graphics.Color
import com.example.compose.ui.orange
import com.example.compose.ui.pink
import com.example.compose.ui.purple
import com.example.compose.ui.red_light

data class TodoItem(
    val name: String = "",
    val checked: Boolean = false,
    val color: Color = red_light
) {

    companion object {
        private val strings =
            listOf("Learn compose", "Take the codelab", "Apply state", "Build dynamic UI's")
        private val colors = listOf(red_light, orange, purple, pink)

        fun createRandomItem() = TodoItem(
            name = strings.random(),
            color = colors.random()
        )
    }
}