package com.example.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.compose.todo.TodoItem

@Composable
fun TodoListItem(
    item: TodoItem,
    modifier: Modifier = Modifier,
    onItemClicked: (TodoItem) -> Unit = {}
) {
    Row(
        modifier = modifier
            .background(color = item.color, shape = RoundedCornerShape(16.dp))
            .clickable { onItemClicked(item) }
    ) {
        Text(
            text = item.name,
            modifier = Modifier.padding(24.dp, 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TodoItemPreview() {
    TodoListItem(TodoItem("Learn compose"), modifier = Modifier.fillMaxWidth())
}