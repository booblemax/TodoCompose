package com.example.compose.todo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.compose.TodoListItem

@Composable
fun TodoScreen(
    items: List<TodoItem>,
    onAddItem: (TodoItem) -> Unit,
    onRemoveItem: (TodoItem) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier.weight(1f).padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach {
                TodoListItem(it, Modifier.fillMaxWidth()) { }
            }
        }
        Button(
            modifier = Modifier.fillMaxWidth().then(Modifier.padding(16.dp)),
            onClick = { onAddItem(TodoItem.createRandomItem()) }
        ) {
            Text(text = "Add random item")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
    TodoScreen(items = listOf(
        TodoItem("Learn compose"),
        TodoItem("Take the codelab", true),
        TodoItem("Apply state"),
        TodoItem("Build dynamic UI's")
    ),
        onAddItem = {}, onRemoveItem = {})
}
