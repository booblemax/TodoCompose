package com.example.compose.todo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun TodoScreen(
    items: List<TodoItem>,
    onAddItem: (TodoItem) -> Unit,
    onRemoveItem: (TodoItem) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(1f)) {
            items.forEach {
                TodoListItem(it, Modifier.fillMaxWidth()) { }
            }
        }
        Button(
            modifier = Modifier.fillMaxWidth().then(Modifier.padding(16.dp)),
            onClick = {}
        ) {
            Text(text = "Add random item")
        }
    }
}

@Composable
fun TodoListItem(
    item: TodoItem,
    modifier: Modifier = Modifier,
    onItemClicked: (TodoItem) -> Unit = {}
) {
    Row(
        modifier = modifier.padding(16.dp).clickable { onItemClicked(item) },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = item.name)
        Checkbox(checked = item.checked, onCheckedChange = { })
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun TodoScreenPreview() {
//    TodoScreen(items = listOf(
//        TodoItem("Learn compose"),
//        TodoItem("Take the codelab", true),
//        TodoItem("Apply state"),
//        TodoItem("Build dynamic UI's")
//    ),
//        onAddItem = {}, onRemoveItem = {})
//}

@Preview(showBackground = true)
@Composable
fun TodoItemPreview() {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            TodoListItem(TodoItem("Learn compose"), modifier = Modifier.fillMaxWidth())
        }
    }
}