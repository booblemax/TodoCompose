package com.example.compose.todo

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.compose.R
import com.example.compose.TodoListItem
import com.example.compose.ui.red

@Composable
fun TodoScreen(
    items: List<TodoItem>,
    onAddItem: (TodoItem) -> Unit,
    onRemoveItem: (TodoItem) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        ScrollableColumn(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach {
                TodoListItem(it, Modifier.fillMaxWidth()) { }
            }
        }
        FloatingActionButton(
            modifier = Modifier.align(Alignment.BottomCenter).padding(PaddingValues(bottom = 16.dp)),
            onClick = { onAddItem(TodoItem.createRandomItem()) },
            backgroundColor = red,
            contentColor = Color.White,
            icon = { Icon(asset = vectorResource(id = R.drawable.ic_add)) }
        )
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
