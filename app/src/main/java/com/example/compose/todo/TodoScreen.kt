package com.example.compose.todo

import androidx.compose.animation.asDisposableClock
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AnimationClockAmbient
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.compose.R
import com.example.compose.TodoListItem
import com.example.compose.ui.ComposeTheme
import com.example.compose.ui.gray_80

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TodoScreen(
    items: List<TodoItem>,
    onAddItem: (TodoItem) -> Unit,
    onRemoveItem: (TodoItem) -> Unit
) {
    val sheetState = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        ScrollableColumn(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach { item ->
                TodoListItem(item, Modifier.fillMaxWidth(), onRemoveItem)
            }
        }
        FloatingActionButton(
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(PaddingValues(bottom = 16.dp)),
            onClick = { sheetState.value = true },
            contentColor = Color.White,
            icon = { Icon(asset = vectorResource(id = R.drawable.ic_add)) }
        )
        if (sheetState.value) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = gray_80
            ) { }
            TodoCreateOrEdit(
                modifier = Modifier.align(Alignment.BottomCenter)
                    .background(MaterialTheme.colors.surface, RoundedCornerShape(topLeft = 24.dp, topRight = 24.dp)),
                onComplete = {
                sheetState.value = false
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
    ComposeTheme {
        TodoScreen(items = listOf(
            TodoItem("Learn compose"),
            TodoItem("Take the codelab", true),
            TodoItem("Apply state"),
            TodoItem("Build dynamic UI's")
        ),
            onAddItem = {}, onRemoveItem = {})
    }
}
